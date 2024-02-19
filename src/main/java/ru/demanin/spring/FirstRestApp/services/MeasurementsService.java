package ru.demanin.spring.FirstRestApp.services;

import org.springframework.stereotype.Service;
import ru.demanin.spring.FirstRestApp.models.Measurements;
import ru.demanin.spring.FirstRestApp.repositories.MeasurementsRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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


    public Measurements save(Measurements measurements) {
        enrichMeasurements(measurements);
        return measurementsRepository.save(measurements);

    }

    public long RainyDaysCount() {
        return findAll().stream().filter(m -> m.isRaining() == true).count();

    }

    private void enrichMeasurements(Measurements measurements) {
        measurements.setCreated_at(LocalDateTime.now());

    }

}
