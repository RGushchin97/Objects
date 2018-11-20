package streams;

import com.sun.istack.internal.Nullable;
import models.Model;
import models.ModelEnum;

import java.util.*;
import java.util.stream.Collectors;

public class ModelsStream {
    private List<Model> models;

    public ModelsStream(List<Model> models) {
        this.models = models;
    }

    public List<Model> getPage(int pageNumber, int size, @Nullable Comparator<Model> comparator) {
        List<Model> modelsList = models;
        if(comparator != null) {
            modelsList = getSorted(comparator);
        }

        return modelsList.stream()
                .skip(size * (pageNumber - 1))
                .limit(size)
                .collect(Collectors.toList());
    }

    public List<Model> getSorted(Comparator<Model> comparator) {
        return models.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }


    public Map<ModelEnum, List<Model>> getMapByEnum() {
        return models.stream()
                .collect(Collectors.groupingBy(Model::getModelEnum));
    }
}
