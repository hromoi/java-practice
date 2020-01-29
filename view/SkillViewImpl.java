package view;

import model.Skill;
import java.util.List;

public class SkillViewImpl implements SkillView<Skill>{
    public void printList(List<Skill> list){
        list.stream().forEach(n -> System.out.println(n));
    }

    public void print(Skill skill){
        System.out.println(skill);
    }
}
