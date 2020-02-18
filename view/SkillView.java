package view;

import controller.SkillController;
import controller.SkillControllerImpl;
import service.Skill;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SkillView {
    private SkillController skillController = new SkillControllerImpl();

    public void getById(Long id){
        System.out.println(skillController.getById(id));
    }

    public void update(Skill skill){
        System.out.println(skillController.update(skill));
    }

    public void deleteById(Long id){
        skillController.deleteById(id);
        skillController.getAll().stream().forEach(System.out::println);
    }

    public void save(Skill skill){
        System.out.println(skillController.save(skill));
    }

    public void getAll(){
        skillController.getAll().stream().forEach(skill -> System.out.println(skill));
    }

    public void parseAndPrint(SkillView skillView){
        String[] str = new String[2];
        BufferedReader buffer;
        try {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            str = buffer.readLine().split(",");
        } catch (Exception e){
            System.out.println("error " + e);
        }
        switch (str[0]){
            case ("1"):
                skillView.getAll();
                break;
            case ("2"):
                skillView.getById(Long.valueOf(str[1]));
                break;
            case ("3"):
                skillView.deleteById(Long.valueOf(str[1]));
                break;
            case ("4"):
                skillView.update(new Skill(Long.valueOf(str[1]), str[2]));
                break;
            case ("5"):
                skillView.save(new Skill(Long.valueOf(str[1]), str[2]));
            default:
                break;
        }
    }
}
