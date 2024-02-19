package ru.demanin.spring.FirstRestApp.dto;

import ru.demanin.spring.FirstRestApp.models.Sensor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MeasurementsDTO {

    @ManyToOne()
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public String getSensor() {
        return sensor.getName();
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @NotNull(message = "Поле не должно быть пустым")
    @DecimalMin(value = "-100.0")
    @DecimalMax(value = "100.0")
    private double value;
    private boolean raining;

    private LocalDateTime created_at;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
