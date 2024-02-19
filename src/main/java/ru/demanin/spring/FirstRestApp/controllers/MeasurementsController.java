package ru.demanin.spring.FirstRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demanin.spring.FirstRestApp.dto.MeasurementsDTO;
import ru.demanin.spring.FirstRestApp.models.Measurements;
import ru.demanin.spring.FirstRestApp.services.MeasurementsService;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<MeasurementsDTO> getMeasurements() {
        return measurementsService.findAll().stream().map(this::convertToMeasurementsDTO).
                collect(Collectors.toList());
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MeasurementsDTO measurementsDTO,
                                             BindingResult bindingResult) {


        measurementsService.save(convertToMeasurements(measurementsDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public MeasurementsDTO getMeasurements(@PathVariable("id") int id) {
        return convertToMeasurementsDTO(measurementsService.findOne(id)); // Jackson конвертирует в JSON
    }

    @GetMapping("/rainyDaysCount")
    public long RainyDaysCount() {
        return measurementsService.RainyDaysCount();
    }

    private Measurements convertToMeasurements(MeasurementsDTO measurementsDTO) {
        return modelMapper.map(measurementsDTO, Measurements.class);
    }

    private MeasurementsDTO convertToMeasurementsDTO(Measurements measurements) {
        return modelMapper.map(measurements, MeasurementsDTO.class);
    }

}
