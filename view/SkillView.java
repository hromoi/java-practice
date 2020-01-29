package view;

import java.util.List;

public interface SkillView<T> {
    void printList(List<T> list);
    void print(T t);
}
