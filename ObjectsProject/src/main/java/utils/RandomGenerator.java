package utils;

import factories.ModelFactory;
import models.Model;
import models.ModelEnum;
import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static Random random = new Random();

    private static String getString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    private static Double getDouble(Double min, Double max) {
        return (min + (max - min) * random.nextDouble());
    }

    private static LocalDate getDate(int minYear, int maxYear) {
        long minDay = LocalDate.of(minYear, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(maxYear, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private static ModelEnum getModelEnum() {
        List<ModelEnum> values = ModelEnum.getValues();
        return values.get(random.nextInt(values.size()));
    }

    public static List<Model> getRandomModels(int count) {
        ModelFactory<Model> factory = Model::new;
        List<Model> models = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            models.add(factory.create(getString(10), getDate(2015, 2018), getDouble(-100.0, 100.0),
                    getModelEnum()));
        }
        return models;
    }
}
