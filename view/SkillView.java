package view;

import controller.SkillController;
import controller.SkillControllerImpl;
import service.Skill;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SkillView {
    private SkillController skillController = new SkillControllerImpl();
    private SkillView skillView = new SkillView();

    public void print(){
        skillController.getAll().stream().forEach(System.out::println);
    }

    public void getById(Long id){
        System.out.println(skillController.getById(id).toString());
    }

    public void update(Skill skill){
        System.out.println(skillController.update(skill).toString());
    }

    public void deleteById(Long id){
        skillController.deleteById(id);
        skillView.print();
    }

    public void save(Skill skill){
        System.out.println(skillController.save(skill).toString());
    }

    public void getAll(){
        skillController.getAll().stream().forEach(skill -> System.out.println(skill));
    }

    public void parseAndPrint(){
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
