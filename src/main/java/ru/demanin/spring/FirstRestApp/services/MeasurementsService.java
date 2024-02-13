package ru.demanin.spring.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demanin.spring.FirstRestApp.models.Measurements;
import ru.demanin.spring.FirstRestApp.models.Sensor;
import ru.demanin.spring.FirstRestApp.repositories.MeasurementsRepository;
import ru.demanin.spring.FirstRestApp.util.SensorNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MeasurementsService {
   private final MeasurementsRepository measurementsRepository;

    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    public List<Measurements> findAll() {
        return measurementsRepository.findAll();

    }
    public Measurements findOne(int id) {
        Optional<Measurements> foundPerson = measurementsRepository.findById(id);
        return foundPerson.orElse(null);
    }




   public Measurements save(Measurements measurements){
       // long l=findAll().stream().filter(m-> m.isRaining()==true).count();



        return measurementsRepository.save(measurements);

    }

}
