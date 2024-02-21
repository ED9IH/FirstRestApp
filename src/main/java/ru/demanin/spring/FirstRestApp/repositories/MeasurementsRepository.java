package ru.demanin.spring.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.demanin.spring.FirstRestApp.models.Measurements;


@Repository
public interface MeasurementsRepository extends
        JpaRepository<Measurements,Integer> {

}
