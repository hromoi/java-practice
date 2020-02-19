package controller;

import model.Skill;
import service.SkillService;

import java.util.List;

public class SkillController {
    private SkillService skillService = new SkillService();

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
