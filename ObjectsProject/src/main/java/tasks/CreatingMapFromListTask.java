package tasks;

import models.Model;
import models.ModelEnum;
import streams.ModelsStream;
import utils.PropertyReader;

import java.util.List;

import static utils.RandomGenerator.getRandomModels;

public class CreatingMapFromListTask {
    public static void main(String[] args) {
        int objectsCount = PropertyReader.getIntProperty("objects.count");
        System.out.println("**********SECOND TASK**********");
        List<Model> models2 = getRandomModels(objectsCount);
        ModelsStream modelsStream2 = new ModelsStream(models2);

        System.out.println("All objects: ");
        models2.forEach(System.out::println);

        ModelEnum modelEnum = ModelEnum.valueOf(PropertyReader.getProperty("enum"));
        System.out.println("\nList of elements by enum " + modelEnum + ":");
        modelsStream2.getMapByEnum().get(modelEnum).forEach(System.out::println);
    }
}
