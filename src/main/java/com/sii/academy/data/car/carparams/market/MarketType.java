package com.sii.academy.data.car.carparams.market;

public enum MarketType {
    BUSINESS("Business"), CARGO("Cargo"), TRANSPORT("Transport"), TAXI("Taxi"), BUS("bus");
    private final String type;

    MarketType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
