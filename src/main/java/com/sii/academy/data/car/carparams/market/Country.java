package com.sii.academy.data.car.carparams.market;

import com.sii.academy.data.car.carparams.CarParam;

import java.util.Objects;

public class Country implements CarParam {
    private String countryName;
    private char countrySign;

    public Country(String countryName, char countrySign) {
        this.countryName = countryName;
        this.countrySign = countrySign;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public char getCountrySign() {
        return countrySign;
    }

    public void setCountrySign(char countrySign) {
        this.countrySign = countrySign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countrySign == country.countrySign && Objects.equals(countryName, country.countryName);
    }

    public String countryName() {
        return countryName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, countrySign);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countrySign=" + countrySign +
                '}';
    }
}
