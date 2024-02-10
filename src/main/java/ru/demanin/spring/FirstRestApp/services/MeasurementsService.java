package ru.demanin.spring.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demanin.spring.FirstRestApp.models.Measurements;
import ru.demanin.spring.FirstRestApp.models.Sensor;
import ru.demanin.spring.FirstRestApp.repositories.MeasurementsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MeasurementsServis {
    private final MeasurementsRepository measurementsRepository;

    @Autowired
    public MeasurementsServis(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    public List<MeasurementsRepository> findAll() {
        return measurementsRepository.findAll();

    }

    @Transactional
   public void save(Measurements measurements){
       
    }

}
