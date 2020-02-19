package service;

import model.Skill;
import repository.SkillRepository;
import repository.javaio.JavaIOSkillRepositoryImpl;

import java.util.List;

public class SkillServiceImpl implements SkillService<Skill> {
    private SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

    @Override
    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}