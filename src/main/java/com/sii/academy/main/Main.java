package com.sii.academy.main;

import com.sii.academy.data.DataHandler;
import com.sii.academy.data.car.Car;
import com.sii.academy.data.car.carparams.CarParam;
import com.sii.academy.data.car.carparams.Dimensions;
import com.sii.academy.data.car.carparams.Producer;
import com.sii.academy.data.car.finder.DimensionLessComparator;
import com.sii.academy.data.car.finder.Finder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Car> carList = DataHandler.buildData(15, 10, 5, 5, 10); // Generate list of 15 cars
        carList.forEach(System.out::println);
        List<CarParam> knownParams = createParamsToTest();
        List<Car> carListToTest = DataHandler.buildCarsFromFile();
        Comparator<Dimensions> comparator = new DimensionLessComparator(); // implement comparator related to dimensions equality you need
        Finder.findCarInList(carListToTest, knownParams, comparator).forEach(System.out::println); // Look for citroen zx with possible height bigger than 340
    }

    private static List<CarParam> createParamsToTest() {
        Producer producer = new Producer("citroen", "ZX");
        Dimensions dimensions = new Dimensions(340, 0, 0, 0);
        List<CarParam> knownParams = new ArrayList<>();
        knownParams.add(producer);
        knownParams.add(dimensions);
        return knownParams;
    }
}