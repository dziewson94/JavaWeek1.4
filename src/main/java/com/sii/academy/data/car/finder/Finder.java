package com.sii.academy.data.car.finder;

import com.sii.academy.data.car.Car;
import com.sii.academy.data.car.carparams.*;
import com.sii.academy.data.car.carparams.market.Country;
import com.sii.academy.data.car.carparams.market.Market;

import java.util.Comparator;
import java.util.List;

public class Finder {

    public static List<Car> findCarInList(List<Car> carList, List<CarParam> knownParams, Comparator<Dimensions> dimensionsComparator) {
        return carList.stream().filter(car -> machAllParams(knownParams, car, dimensionsComparator)).toList();
    }

    private static boolean machAllParams(List<CarParam> knownParams, Car car, Comparator<Dimensions> dimensionsComparator) {
        boolean result = true;
        for (CarParam param : knownParams) {
            result = result && checkCar(param, car, dimensionsComparator);

        }
        return result;

    }

    private static boolean checkCar(CarParam param, Car car, Comparator<Dimensions> dimensionsComparator) {
        if (param instanceof Producer) {
            return car.getProducer().equals(param);
        } else if (param instanceof GearType) {
            return car.getGearType().equals(param);
        } else if (param instanceof Market) {
            return car.getMarket().equals(param);
        } else if (param instanceof Country) {
            return car.getMarket().getCountries().stream().anyMatch(c -> c.equals(param));
        } else if (param instanceof CarSegment) {
            return car.getCarSegment().equals(param);
        } else if (param instanceof Dimensions) {
            return car.getPossibleDimensionsList().stream().anyMatch(dim -> dimensionsComparator.compare(dim, (Dimensions) param) == 1);
        }
        return false;
    }
}
