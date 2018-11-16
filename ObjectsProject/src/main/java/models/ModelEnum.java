package models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ModelEnum {
    BIG_MODEL,
    SMALL_MODEL,
    MEDIUM_MODEL,
    LARGE_MODEL,
    GENERAL_MODEL;

    public static List<ModelEnum> getValues() {
        return Collections.unmodifiableList(Arrays.asList(values()));
    }
}
