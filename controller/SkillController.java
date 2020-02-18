package controller;

import java.util.List;

public interface SkillController<T> {
    T update(T t);
    T save(T t);
    T getById(Long id);
    void deleteById(Long id);
    List<T> getAll();
}
