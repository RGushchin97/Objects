package tasks;

import models.Model;
import streams.ModelsStream;
import utils.PropertyReader;

import static comparators.ModelComparator.getComparator;

import java.util.List;

import static utils.RandomGenerator.getRandomModels;

public class SortingAngPaginatingTask {

    public static void main(String[] args) {
        int objectsCount = PropertyReader.getIntProperty("objects.count");

        System.out.println("**********FIRST TASK**********");
        List<Model> models = getRandomModels(objectsCount);
        ModelsStream modelsStream = new ModelsStream(models);

        String compare = PropertyReader.getProperty("compare");
        boolean descending = PropertyReader.getBooleanProperty("descending");

        System.out.println("All objects: ");
        modelsStream
                .getSorted(getComparator(compare, descending))
                .forEach(System.out::println);

        int pageSize = PropertyReader.getIntProperty("page.size");
        int pageNumber = PropertyReader.getIntProperty("page.number");
        System.out.println("\nObjects at " + pageNumber + " page:");
        modelsStream
                .getPage(pageNumber, pageSize, getComparator(compare, descending))
                .forEach(System.out::println);
    }
}
