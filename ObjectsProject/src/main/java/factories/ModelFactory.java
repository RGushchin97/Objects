package factories;

import models.Model;
import models.ModelEnum;

import java.time.LocalDate;

public interface ModelFactory<M extends Model> {
    M create(String name, LocalDate date, Double value, ModelEnum modelEnum);
}
