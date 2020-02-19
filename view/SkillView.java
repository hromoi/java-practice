package view;

import controller.SkillController;
import model.Skill;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SkillView {
    private static SkillController skillController = new SkillController();

    public static void getById(Long id) {
        System.out.println(skillController.getById(id));
    }

    public static void update(Skill skill) {
        System.out.println(skillController.update(skill));
    }

    public static void deleteById(Long id) {
        skillController.deleteById(id);
        skillController.getAll().stream().forEach(System.out::println);
    }

    public static void save(Skill skill) {
        System.out.println(skillController.save(skill));
    }

    public static void getAll() {
        skillController.getAll().stream().forEach(skill -> System.out.println(skill));
    }

    public static void parseAndPrint() {
        String[] str = new String[2];
        SkillView skillView = new SkillView();
        BufferedReader buffer;
        try {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            str = buffer.readLine().split(",");
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        switch (str[0]) {
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
