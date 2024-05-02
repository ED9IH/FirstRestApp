package ru.demanin.spring.FirstRestApp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SensorDTO {
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 3, max = 30, message = "В название сенсора должно быть не меньше 3 и не более 30 символов")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
