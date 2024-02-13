package ru.demanin.spring.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.demanin.spring.FirstRestApp.models.Sensor;
import ru.demanin.spring.FirstRestApp.services.SensorService;
import ru.demanin.spring.FirstRestApp.util.SensorErrorResponse;
import ru.demanin.spring.FirstRestApp.util.SensorNotCreatedException;
import ru.demanin.spring.FirstRestApp.util.SensorNotFoundException;

import javax.validation.Valid;
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
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors=bindingResult.getFieldErrors();
            for(FieldError error:errors){
                errorMsg.append(error.getField()).append(" - ").
                        append(error.getDefaultMessage())
                        .append(";");
            }
            throw new SensorNotCreatedException(errorMsg.toString());
        }
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<SensorErrorResponse> handleException(SensorNotFoundException e) {
        SensorErrorResponse sensorErrorResponse = new SensorErrorResponse("Такой сенсор не зарегистрирован");
        return new ResponseEntity<>(sensorErrorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<SensorErrorResponse> handleException(SensorNotCreatedException e) {
        SensorErrorResponse sensorErrorResponse = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(sensorErrorResponse, HttpStatus.BAD_REQUEST);

    }





}



