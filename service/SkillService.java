package service;

import java.util.List;

public interface SkillService<T> {
    T update(T t);
    T save(T t);
    T getById(Long id);
    void deleteById(Long id);
    List<T> getAll();
}
