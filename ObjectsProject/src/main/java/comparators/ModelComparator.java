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
        Comparator<Model> comparator;
        if(!descending) {
            comparator = Comparator.comparing(Model::getName);
        } else {
            comparator = (a, b) -> b.getName().compareTo(a.getName());
        }
        return comparator;
    }

    private static Comparator<Model> getDateComparator(@NotNull boolean descending) {
        Comparator<Model> comparator;
        if(!descending) {
            comparator = Comparator.comparing(Model::getDate);
        } else {
            comparator = (a, b) -> b.getDate().compareTo(a.getDate());
        }
        return comparator;
    }

    private static Comparator<Model> getValueComparator(@NotNull boolean descending) {
        Comparator<Model> comparator;
        if(!descending) {
            comparator = Comparator.comparing(Model::getValue);
        } else {
            comparator = (a, b) -> b.getValue().compareTo(a.getValue());
        }
        return comparator;
    }

    private static Comparator<Model> getEnumComparator(@NotNull boolean descending) {
        Comparator<Model> comparator;
        if(!descending) {
            comparator = Comparator.comparing(Model::getModelEnum);
        } else {
            comparator = (a, b) -> b.getModelEnum().toString().compareTo(a.getModelEnum().toString());
        }
        return comparator;
    }
}
