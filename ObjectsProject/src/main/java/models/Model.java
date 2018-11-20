package models;

import java.time.LocalDate;

public class Model {

    private String name;
    private LocalDate date;
    private Double value;
    private ModelEnum modelEnum;

    public Model(String name, LocalDate date, Double value, ModelEnum modelEnum) {
        this.name = name;
        this.date = date;
        this.value = value;
        this.modelEnum = modelEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ModelEnum getModelEnum() {
        return modelEnum;
    }

    public void setModelEnum(ModelEnum modelEnum) {
        this.modelEnum = modelEnum;
    }

    @Override
    public String toString() {
        return new StringBuilder
                ("Name: ").append(name)
                .append(", Date: ").append(date)
                .append(", Value: ").append(value)
                .append(", Enum: ").append(modelEnum)
                .substring(0);
    }
}
