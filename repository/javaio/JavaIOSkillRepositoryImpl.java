package repository.javaio;

import service.Skill;
import repository.SkillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    public Skill getById(Long id){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt")))){
            String[] array;
            String str;
            for (int i = 0; i <= id; i++) {
                if ((str = reader.readLine()) != null && i == id){
                    return parse(str);
                }
            }
        } catch (IOException e){
            System.out.println("error i/o");
        }
        return null;
    }

    public List<Skill> getAll(){
        List<Skill> myList = new ArrayList<>();;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt")))){
            String str;
            do {
                if ((str = reader.readLine()) != null){
                    myList.add(parse(str));
                }
            } while (str != null);
        } catch (IOException e){
            System.out.println("error i/o");
        }
        return myList;
    }

    public Skill save(Skill skill){
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt", true)))){
            writer.write(new String(skill.getId() + "," + skill.getName()));
        } catch (IOException e){
            System.out.println("error i/o");
        }
        return skill;
    }

    public void deleteById(Long id){
        List<Skill> myList = new ArrayList<>();
        List<Skill> resultMyList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt")))){
            String str = null;
            do{
                if ((str = reader.readLine()) != null){
                    myList.add(parse(str));
                }
            } while (str != null);
        } catch (IOException e){
            System.out.println("error reader i/o");
        }

        for (Skill skill : myList) {
            if (skill.getId() != id)
                resultMyList.add(skill);
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt")))){
            for (Skill skill : resultMyList) {
                writer.write(new String(skill.getId() + "," + skill.getName() + "\n"));
            }
        } catch (IOException e2){
            System.out.println("error writer i/o");
        }
    }

    public Skill update(Skill skill){
        List<Skill> myList = new ArrayList<>();
        List<Skill> resultMyList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt")))){
            String str;
            do {
                if ((str = reader.readLine()) != null){
                   myList.add(parse(str));
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
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skills.txt")))){
            for (Skill resultObj : resultMyList) {
                writer.write(new String(resultObj.getId() + "," + resultObj.getName() + "\n"));
            }
        } catch (IOException e){
            System.out.println("error writer i/o");
        }
        return skill;
    }

    private Skill parse(String str){
        return new Skill(Long.valueOf(str.split(",+")[0]), str.split(",+")[1]);
    }
}
