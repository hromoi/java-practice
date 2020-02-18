package controller;

import service.Skill;
import service.SkillService;
import service.SkillServiceImpl;
import java.util.List;

public class SkillControllerImpl implements SkillController<Skill> {
    private SkillService skillService = new SkillServiceImpl();

    @Override
    public Skill save(Skill skill){
        return (Skill) skillService.save(skill);
    }
    @Override
    public Skill update(Skill skill){
        return ((Skill) skillService.update(skill));
    }
    @Override
    public void deleteById(Long id){
        skillService.deleteById(id);
    }
    @Override
    public List<Skill> getAll(){
        return skillService.getAll();
    }
    @Override
    public Skill getById(Long id){
        return ((Skill) skillService.getById(id));
    }
}
