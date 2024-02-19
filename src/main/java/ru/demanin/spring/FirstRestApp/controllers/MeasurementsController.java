package ru.demanin.spring.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demanin.spring.FirstRestApp.models.Measurements;
import ru.demanin.spring.FirstRestApp.services.MeasurementsService;


import javax.validation.Valid;
import java.util.List;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
@Autowired
    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @GetMapping()
   public List<Measurements> getMeasurements(){
      return measurementsService.findAll();
   }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Measurements measurements,
                                             BindingResult bindingResult) {



       measurementsService.save(measurements);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Measurements getMeasurements(@PathVariable("id") int id) {
        return measurementsService.findOne(id); // Jackson конвертирует в JSON
    }
    @GetMapping("/rainyDaysCount")
    public long RainyDaysCount(){
    return measurementsService.RainyDaysCount();
    }

}
