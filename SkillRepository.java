import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {

    public Skill getById(Long id){
        Skill skill = new Skill();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            String[] array;
            String str;
            for (int i = 0; i <= id; i++) {
                if ((str = reader.readLine()) != null && i == id){
                    array = str.split(",+");
                    skill.setId(Long.valueOf(array[0]));
                    skill.setName(array[1]);
                    break ;
                }
            }
        } catch (IOException e){
            System.out.println("error i/o");
        }
        return skill;
    }

    public List<Skill> getAll(){
        ArrayList<Skill> myList = new ArrayList<>();;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            String str;
            String[] array;
            do {
                if ((str = reader.readLine()) != null){
                    array = str.split(",+");
                    myList.add(new Skill(Long.valueOf(array[0]), array[1]));
                }
            } while (str != null);
        } catch (IOException e){
            System.out.println("error i/o");
        }
        return myList;
    }

    public Skill save(Skill skill){
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt", true)))){
            writer.write(new String(skill.getId() + "," + skill.getName()));
        } catch (IOException e){
            System.out.println("error i/o");
        }
        return skill;
    }

    public void deleteById(Long id){
        ArrayList<Skill> myList = new ArrayList<>();
        ArrayList<Skill> resultMyList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            String str = null;
            String[] array;
            do{
                if ((str = reader.readLine()) != null){
                    array = str.split(",+");
                    myList.add(new Skill(Long.valueOf(array[0]), array[1]));
                }
            } while (str != null);
        } catch (IOException e){
            System.out.println("error reader i/o");
        }

        for (Skill skill : myList) {
            if (skill.getId() != id)
                resultMyList.add(skill);
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            for (Skill skill : resultMyList) {
                writer.write(new String(skill.getId() + "," + skill.getName() + "\n"));
            }
        } catch (IOException e2){
            System.out.println("error writer i/o");
        }
    }

    public Skill update(Skill skill){
        ArrayList<Skill> myList = new ArrayList<>();
        ArrayList<Skill> resultMyList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            String str;
            do {
                if ((str = reader.readLine()) != null){
                   myList.add(new Skill(Long.valueOf(str.split(",+")[0]), str.split(",+")[1]));
                }
            } while (str != null);
        } catch (IOException e){
            System.out.println("error reader i/o");
        }
        for (Skill obj : myList) {
            if (obj.getId() == skill.getId()){
                resultMyList.add(skill);
            }else{
                resultMyList.add(obj);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            for (Skill resultObj : resultMyList) {
                writer.write(new String(resultObj.getId() + "," + resultObj.getName() + "\n"));
            }
        } catch (IOException e){
            System.out.println("error writer i/o");
        }
        return skill;
    }
}
