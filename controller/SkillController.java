package controller;

import service.Skill;
import service.SkillService;
import service.SkillServiceImpl;

import java.util.List;

public class SkillController {
    private SkillService<Skill> skillService = new SkillServiceImpl();

    public Skill save(Skill skill) {
        return skillService.save(skill);
    }

    public Skill update(Skill skill) {
        return skillService.update(skill);
    }

    public void deleteById(Long id) {
        skillService.deleteById(id);
    }

    public List<Skill> getAll() {
        return skillService.getAll();
    }

    public Skill getById(Long id) {
        return skillService.getById(id);
    }
}
