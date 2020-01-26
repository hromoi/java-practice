package Main;

import Model.Skill;
import Repository.SkillRepository;
import Repository.SkillRepositoryImpl;

import java.util.List;

public class Main {

    public static void main(String[] args){
        SkillRepository skillRepository = (SkillRepository)new SkillRepositoryImpl();
//        Model.Skill skill;
//        skill = skillRepository.getById(0L);
//        System.out.println(skill.toString());
//        List<Skill> myList = skillRepository.getAll();
//        for (Model.Skill obj : myList) {
//            System.out.println(obj.toString());
//        }
//        Model.Skill skill = new Model.Skill(3, "vasya\n");
//        skillRepository.save(skill);
//        System.out.println();
//        myList = skillRepository.getAll();
//        for (Skill obj : myList) {
//            System.out.println(obj.toString());
//        }
//        skillRepository.deleteById(347L);
//        System.out.println();
//        myList = skillRepository.getAll();
//        for (Model.Skill obj : myList) {
//            System.out.println(obj.toString());
//        }
//        skillRepository.update(new Skill(7, "Alexei"));
//        myList = skillRepository.getAll();
//        for (Skill obj : myList) {
//            System.out.println(obj.toString());
//        }
        System.out.println(skillRepository.parse("5,C++").toString());
    }
}