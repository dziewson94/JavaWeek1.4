package com.sii.academy.data.car.carparams.market;

import com.sii.academy.data.car.carparams.CarParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Market implements CarParam {
    private String marketName;
    private List<Country> countries = new ArrayList<>();

    public Market(String marketName, List<CarParam> countries) {
        this.marketName = marketName;
        countries.forEach(el -> {
            if (el instanceof Country) this.countries.add((Country) el);
        });
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return marketName.equals(market.marketName) && countries.equals(market.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketName, countries);
    }

    @Override
    public String toString() {
        return "Market{" +
                "marketName='" + marketName + '\'' +
                ", countries=" + countries +
                '}';
    }
}
