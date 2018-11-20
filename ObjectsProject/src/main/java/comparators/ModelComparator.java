package comparators;

import com.sun.istack.internal.NotNull;
import models.Model;

import java.util.Comparator;

public class ModelComparator {

    public static Comparator<Model> getComparator(String fieldName, @NotNull boolean descending) {
        switch(fieldName.toLowerCase()) {
            case "date": return getDateComparator(descending);
            case "name": return getNameComparator(descending);
            case "value": return getValueComparator(descending);
            case "enum": return getEnumComparator(descending);
            default: return getNameComparator(descending);
        }
    }

    private static Comparator<Model> getNameComparator(@NotNull boolean descending) {
        Comparator<Model> comparator = Comparator.comparing(Model::getName);
        return checkDescending(comparator, descending);
    }

    private static Comparator<Model> getDateComparator(@NotNull boolean descending) {
        Comparator<Model> comparator = Comparator.comparing(Model::getDate);
        return checkDescending(comparator, descending);
    }

    private static Comparator<Model> getValueComparator(@NotNull boolean descending) {
        Comparator<Model> comparator = Comparator.comparing(Model::getValue);
        return checkDescending(comparator, descending);
    }

    private static Comparator<Model> getEnumComparator(@NotNull boolean descending) {
        Comparator<Model> comparator = Comparator.comparing(a -> a.getModelEnum().toString());
        return (checkDescending(comparator, descending));
    }

    private static Comparator<Model> checkDescending(Comparator<Model> comparator, boolean descending) {
        if(descending) {
            return comparator.reversed();
        }
        return comparator;
    }
}
