package repository;

import java.util.List;

public interface GenericRepository<T,ID> {
    T getById(ID id);
    List<T> getAll();
    T update(T type);
    T save(T type);
    void deleteById(ID id);
}
