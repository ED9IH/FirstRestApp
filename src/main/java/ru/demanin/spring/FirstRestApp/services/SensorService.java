package ru.demanin.spring.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.demanin.spring.FirstRestApp.models.Measurements;
import ru.demanin.spring.FirstRestApp.models.Sensor;
import ru.demanin.spring.FirstRestApp.repositories.MeasurementsRepository;
import ru.demanin.spring.FirstRestApp.repositories.SensorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;
    @Autowired
    public SensorService(SensorRepository sensorRepository, MeasurementsRepository measurementsRepository) {
        this.sensorRepository = sensorRepository;
    }




    public List<Sensor> findAll() {


        return sensorRepository.findAll();
    }


    public Sensor findOne(int id) {
        Optional<Sensor> foundPerson = sensorRepository.findById(id);
        return foundPerson.orElse(null);
    }



    @Transactional
    public void save(Sensor sensor) {

        sensorRepository.save(sensor);



    }
}











