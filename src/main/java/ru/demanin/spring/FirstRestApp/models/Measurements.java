package ru.demanin.spring.FirstRestApp.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "measurements")
public class Measurements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;
    @NotNull(message = "Поле не должно быть пустым")
    @Column(name = "value")
    @DecimalMin(value = "-100.0")
    @DecimalMax(value = "100.0")
    private double value;
    @Column(name = "raining")
    private boolean raining;

    @Column(name = "rainy_days_count")
    private int rainyDaysCount;


    public Measurements() {
    }

    public Measurements(double value, boolean raining, int rainyDaysCount) {
        this.value = value;
        this.raining = raining;
        this.rainyDaysCount = rainyDaysCount;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

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

    public int getRainyDaysCount() {
        return rainyDaysCount;
    }

    public void setRainyDaysCount(int rainyDaysCount) {
        this.rainyDaysCount = rainyDaysCount;
    }


}
