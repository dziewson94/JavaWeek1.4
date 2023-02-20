package com.sii.academy.data.car.finder;

import com.sii.academy.data.car.Car;
import com.sii.academy.data.car.carparams.*;
import com.sii.academy.data.car.carparams.market.Country;
import com.sii.academy.data.car.carparams.market.Market;

import java.util.List;

public class Finder {

    public static List<Car> findCarInList(List<Car> carList, List<CarParam> knownParams, String dimCom) {
        return carList.stream().filter(car -> machAllParams(knownParams, car, dimCom)).toList();
    }

    private static boolean machAllParams(List<CarParam> knownParams, Car car, String sign) {
        boolean result = true;
        for (CarParam param : knownParams) {
            result = result && checkCar(param, car, sign);

        }
        return result;

    }

    private static boolean checkCar(CarParam param, Car car, String sign) {
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
        } else if (param instanceof Dimensions && !sign.isEmpty()) {
            return car.getPossibleDimensionsList().stream().anyMatch((carDim -> carDim.compareDimension((Dimensions) param, sign)));
        }
        return false;
    }
}
