package ru.demanin.spring.FirstRestApp.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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


}
