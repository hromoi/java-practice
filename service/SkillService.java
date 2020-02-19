package service;

import model.Skill;
import repository.SkillRepository;
import repository.javaio.JavaIOSkillRepositoryImpl;

import java.util.List;

public class SkillService {
    private SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}