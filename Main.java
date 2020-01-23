import java.util.List;

public class Main {

    public static void main(String[] args){
        SkillRepository skillRepository = new SkillRepository();
//        Skill skill;
//        skill = skillRepository.getById(0L);
//        System.out.println(skill.toString());
        List<Skill> myList = skillRepository.getAll();
//        for (Skill obj : myList) {
//            System.out.println(obj.toString());
//        }
//        Skill skill = new Skill(3, "vasya\n");
//        skillRepository.save(skill);
//        System.out.println();
//        myList = skillRepository.getAll();
        for (Skill obj : myList) {
            System.out.println(obj.toString());
        }
//        skillRepository.deleteById(347L);
        System.out.println();
//        myList = skillRepository.getAll();
//        for (Skill obj : myList) {
//            System.out.println(obj.toString());
//        }
        skillRepository.update(new Skill(7, "Alexei"));
        myList = skillRepository.getAll();
        for (Skill obj : myList) {
            System.out.println(obj.toString());
        }
    }
}