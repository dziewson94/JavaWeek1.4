package com.sii.academy.data;

import com.google.gson.Gson;
import com.sii.academy.data.car.Car;
import com.sii.academy.data.car.carparams.*;
import com.sii.academy.data.car.carparams.market.Country;
import com.sii.academy.data.car.carparams.market.Market;
import com.sii.academy.data.car.carparams.market.MarketType;
import com.sii.academy.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataHandler {
    private static final String COUNTRIES_DB_FILE = "countries_db.txt";
    private static final String PRODUCER_DB_FILE = "producer_db.txt";
    private static final String CARS_DB_FILE = "cars_db.txt";
    private static final List<Country> allCountries = new ArrayList<>();
    private static final List<Producer> allProducers = new ArrayList<>();
    private DataHandler() {
    }

    public static void loadDataFromFiles() throws URISyntaxException, IOException {
        List<String> temp;
        temp = FileUtils.readFileAsStringList(PRODUCER_DB_FILE);
        temp.forEach(DataHandler::addProducer);
        temp = FileUtils.readFileAsStringList(COUNTRIES_DB_FILE);
        temp.forEach(DataHandler::addCountry);
    }

    private static void addProducer(String str) {
        String[] prodStr = str.split("\\.");
        if (prodStr.length == 2)
            allProducers.add(new Producer(prodStr[0], prodStr[1]));
    }

    public static List<Car> buildData(int noOfCars, int noOfProducer, int noOfMarkets, int noOfCountries, int noOfDimss) throws URISyntaxException, IOException {
        loadDataFromFiles();
        int[] amounts = new int[5];
        amounts[0] = noOfCars;
        amounts[1] = noOfProducer;
        amounts[2] = noOfMarkets;
        amounts[3] = noOfCountries;
        amounts[4] = noOfDimss;
        return generateParamList(new Car(), amounts).stream().map(Car.class::cast).toList();
    }

    private static void addCountry(String str) {
        allCountries.add(new Country(str, str.charAt(0)));
    }

    private static List<CarParam> generateParamList(CarParam type, int... amount) {
        switch (type.getClass().getName().substring(type.getClass().getName().lastIndexOf('.') + 1)) {
            case "Producer" -> {
                return buildProducers(amount[0]);
            }
            case "Market" -> {
                return buildMarkets(amount[0], amount[1]);
            }
            case "Dimensions" -> {
                return buildDimensions(amount[0]);
            }

            case "Country" -> {
                return buildCountries(amount[0]);
            }
            case "Car" -> {
                return buildCars(amount[0], amount[1], amount[2], amount[3], amount[4]);
            }
            default -> {
                return null;
            }
        }
    }

    private static int getRandomIndex(List<?> list) {
        return ThreadLocalRandom.current().nextInt(0, list.size());
    }

    private static List<CarParam> buildCars(int noOfCars, int noOfProducer, int noOfMarkets, int noOfCountries, int noOfDims) {
        List<CarParam> carProducers = buildProducers(noOfProducer);
        List<CarParam> markets = buildMarkets(noOfMarkets, noOfCountries);
        List<CarParam> result = new ArrayList<>(noOfCars);
        List<GearType> gearTypes = new ArrayList<>(EnumSet.allOf(GearType.class));
        List<CarSegment> carSegments = new ArrayList<>(EnumSet.allOf(CarSegment.class));
        List<CarParam> dimensions = buildDimensions(noOfDims);
        for (int i = 0; i < noOfCars; i++) {
            Producer producer = (Producer) carProducers.get(getRandomIndex(carProducers));
            GearType gearType = gearTypes.get(getRandomIndex(gearTypes));
            Market market = (Market) markets.get(getRandomIndex(markets));
            CarSegment segment = carSegments.get(getRandomIndex(carSegments));
            Set<Dimensions> dimensionsSet = new HashSet<>();
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(1, 5); j++) {
                dimensionsSet.add((Dimensions) dimensions.get(getRandomIndex(dimensions)));
            }
            result.add(new Car(producer, gearType, market, segment, dimensionsSet));
        }
        return result;
    }

    private static List<CarParam> buildCountries(int amount) {
        List<CarParam> result = new ArrayList<>(amount);

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3, 10); i++) {
            result.add(allCountries.get(ThreadLocalRandom.current().nextInt(0, allCountries.size())));
        }
        return result;
    }

    private static List<CarParam> buildDimensions(int amount) {
        List<CarParam> result = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            result.add(new Dimensions(ThreadLocalRandom.current().nextInt(70, 400), ThreadLocalRandom.current().nextInt(130, 260), ThreadLocalRandom.current().nextInt(70, 400), ThreadLocalRandom.current().nextInt(200, 1200)));
        }
        return result;
    }

    private static List<CarParam> buildMarkets(int amount, int amount1) {
        List<CarParam> result = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            result.add(new Market(String.format("Market %d related to %s", (i + 1), randType()), generateParamList(new Country("", ' '), amount1)));
        }
        return result;
    }

    private static List<CarParam> buildProducers(int amount) {
        List<CarParam> result = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            int x = getRandomIndex(allProducers);
            result.add(allProducers.get(x));
        }
        return result;
    }

    private static MarketType randType() {
        List<MarketType> result = new ArrayList<>(EnumSet.allOf(MarketType.class));
        return result.get(ThreadLocalRandom.current().nextInt(0, result.size()));

    }

    public static List<Car> buildCarsFromFile() throws URISyntaxException, IOException {
        List<Car> result = new ArrayList<>();
        Gson jsonParser = new Gson();
        FileUtils.readFileAsStringList(CARS_DB_FILE).forEach(el -> result.add(jsonParser.fromJson(el, Car.class)));
        return result;

    }


}
