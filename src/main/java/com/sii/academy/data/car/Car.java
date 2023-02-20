package com.sii.academy.data.car;

import com.sii.academy.data.car.carparams.*;
import com.sii.academy.data.car.carparams.market.Market;

import java.util.Set;

public class Car implements CarParam {
    private Producer producer;
    private GearType gearType;
    private Market market;
    private CarSegment carSegment;
    private Set<Dimensions> possibleDimensionsList;


    public Car(Producer producer, GearType gearType, Market market, CarSegment carSegment, Set<Dimensions> possibleDimensionsList) {
        this.producer = producer;
        this.gearType = gearType;
        this.market = market;
        this.carSegment = carSegment;
        this.possibleDimensionsList = possibleDimensionsList;
    }

    public Car() {

    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public GearType getGearType() {
        return gearType;
    }

    public void setGearType(GearType gearType) {
        this.gearType = gearType;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public CarSegment getCarSegment() {
        return carSegment;
    }

    public void setCarSegment(CarSegment carSegment) {
        this.carSegment = carSegment;
    }

    public Set<Dimensions> getPossibleDimensionsList() {
        return possibleDimensionsList;
    }

    public void setPossibleDimensionsList(Set<Dimensions> possibleDimensionsList) {
        this.possibleDimensionsList = possibleDimensionsList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer=" + producer +
                ", gearType=" + gearType +
                ", market=" + market +
                ", carSegment=" + carSegment +
                ", possibleDimensionsList=" + possibleDimensionsList +
                '}';
    }
}
