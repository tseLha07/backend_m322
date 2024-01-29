package m320_M322.config.generics;

import java.util.List;

public interface ExtendedService<T extends ExtendedEntity> {
    T save(T entity);

    T updateById(int id, T entity);

    void deleteById(int id);

    List<T> findAll();

    T findById(int id);
}

