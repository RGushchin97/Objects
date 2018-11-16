package tasks;

import models.Model;
import streams.ModelsStream;
import utils.PropertyReader;

import static comparators.ModelComparator.getComparator;

import java.util.List;

import static utils.RandomGenerator.getRandomModels;

public class Task1 {

    public static void main(String[] args) {
        int objectsCount = Integer.parseInt(PropertyReader.getProperty("objects.count"));

        System.out.println("**********FIRST TASK**********");
        List<Model> models = getRandomModels(objectsCount);
        ModelsStream modelsStream = new ModelsStream(models);

        String compare = PropertyReader.getProperty("compare");
        boolean descending = Boolean.parseBoolean(PropertyReader.getProperty("descending"));

        System.out.println("All objects: ");
        modelsStream
                .getSorted(getComparator(compare, descending))
                .forEach(System.out::println);

        int pageSize = Integer.parseInt(PropertyReader.getProperty("page.size"));
        int pageNumber = Integer.parseInt(PropertyReader.getProperty("page.number"));
        System.out.println("\nObjects at " + pageNumber + " page:");
        modelsStream
                .getPage(pageNumber, pageSize, getComparator(compare, descending))
                .forEach(System.out::println);
    }
}
