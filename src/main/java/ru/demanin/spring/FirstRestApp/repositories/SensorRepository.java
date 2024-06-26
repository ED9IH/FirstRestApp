package ru.demanin.spring.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.demanin.spring.FirstRestApp.models.Sensor;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
