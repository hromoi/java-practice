package model;

import repository.SkillRepository;
import repository.javaio.JavaIOSkillRepositoryImpl;
import view.SkillViewImpl;

import java.util.Arrays;
import java.util.List;

public class SkillModelImpl implements SkillModel<String>{

    public void service(String str){
        List<String> list = Arrays.asList(str.split(",+"));
        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();
        SkillViewImpl skillView = new SkillViewImpl();
        switch (list.get(0)){
            case ("1"):
                skillView.printList(skillRepository.getAll());
                break;
            case ("2"):
                skillRepository.update(new Skill(Long.valueOf(list.get(1)), list.get(2)));
                break;
            case ("3"):
                skillRepository.deleteById(Long.valueOf(list.get(1)));
                break;
            case ("4"):
                skillView.print(skillRepository.getById(Long.valueOf(list.get(1))));
                break;
            case ("5"):
                skillRepository.save(new Skill(Long.valueOf(list.get(1)), list.get(2)));
            default:
                break;
        }
    }
}