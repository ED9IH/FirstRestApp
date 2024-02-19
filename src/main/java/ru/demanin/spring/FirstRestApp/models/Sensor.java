package ru.demanin.spring.FirstRestApp.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {
    @OneToMany(mappedBy = "sensor")
    private List<Measurements> measurements;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min=3,max = 30,message = "В название сенсора должно быть не меньше 3 и не более 30 символов")
    @Column(name = "name")

    private String name;


    public Sensor(String name) {
        this.name = name;

    }

    public Sensor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Measurements> getMeasurements() {
//        return measurements;
//    }

//    public void setMeasurements(List<Measurements> measurements) {
//        this.measurements = measurements;
//    }
}
