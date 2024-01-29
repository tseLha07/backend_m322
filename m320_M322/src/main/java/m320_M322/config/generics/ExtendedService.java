package m320_M322.config.generics;

import java.util.List;
import java.util.UUID;

public interface ExtendedService<T extends ExtendedEntity> {
    T save(T entity);

    T updateById(UUID id, T entity);

    void deleteById(UUID id);

    List<T> findAll();

    T findById(UUID id);
}

