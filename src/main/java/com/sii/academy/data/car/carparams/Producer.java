package com.sii.academy.data.car.carparams;

import java.util.Objects;

public class Producer implements CarParam {
    private String brand;
    private String model;

    public Producer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(brand, producer.brand) && Objects.equals(model, producer.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}
