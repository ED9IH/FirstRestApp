package ru.demanin.spring.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demanin.spring.FirstRestApp.models.Sensor;
import ru.demanin.spring.FirstRestApp.services.SensorService;
import ru.demanin.spring.FirstRestApp.util.SensorErrorRespons;
import ru.demanin.spring.FirstRestApp.util.SensorNotFoundException;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;


@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/sensor")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping()
    public List<Sensor> getSensor() {
        return sensorService.findAll(); // Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable("id") int id) {
        return sensorService.findOne(id); // Jackson конвертирует в JSON
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Sensor sensor,
                                             BindingResult bindingResult) {
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorRespons> handleException(SensorNotFoundException e) {
        SensorErrorRespons sensorErrorRespons = new SensorErrorRespons("Такой сенсор уже существует");
        return new ResponseEntity<>(sensorErrorRespons,HttpStatus.NOT_FOUND);

    }


    }



