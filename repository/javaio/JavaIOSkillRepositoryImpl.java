package repository.javaio;

import model.Skill;
import repository.SkillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {
    private final String str = "/Users/user/IdeaProjects/first_crud_application/src/main/resources/files/skills.txt";

    public Skill getById(Long id) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(str)))) {
            String str = reader.readLine();
            do {
                if (str != null && Long.valueOf(str.split(",")[0]) == id) {
                    return parse(str);
                }
            } while ((str = reader.readLine()) != null);
        } catch (IOException e) {
            System.out.println("error i/o");
        }
        return null;
    }

    public List<Skill> getAll() {
        List<Skill> myList = new ArrayList<>();
        ;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(str)))) {
            String str;
            do {
                if ((str = reader.readLine()) != null) {
                    myList.add(parse(str));
                }
            } while (str != null);
        } catch (IOException e) {
            System.out.println("error i/o");
        }
        return myList;
    }

    public Skill save(Skill skill) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str, true)))) {
            writer.write(new String(skill.getId() + "," + skill.getName()));
        } catch (IOException e) {
            System.out.println("error i/o");
        }
        return skill;
    }

    public void deleteById(Long id) {
        List<Skill> myList = new ArrayList<>();
        List<Skill> resultMyList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(str)))) {
            String str = reader.readLine();
            do {
                if (str != null) {
                    myList.add(parse(str));
                }
            } while ((str = reader.readLine()) != null);
        } catch (IOException e) {
            System.out.println("error reader i/o");
        }

        for (Skill skill : myList) {
            if (skill.getId() != id)
                resultMyList.add(skill);
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)))) {
            for (Skill skill : resultMyList) {
                writer.write(new String(skill.getId() + "," + skill.getName() + "\n"));
            }
        } catch (IOException e2) {
            System.out.println("error writer i/o");
        }
    }

    public Skill update(Skill skill) {
        List<Skill> myList = new ArrayList<>();
        List<Skill> resultMyList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(str)))) {
            String str = reader.readLine();
            do {
                if (str != null) {
                    myList.add(parse(str));
                }
            } while ((str = reader.readLine()) != null);
        } catch (IOException e) {
            System.out.println("error reader i/o");
        }
        for (Skill obj : myList) {
            if (obj.getId() == skill.getId()) {
                resultMyList.add(skill);
            } else {
                resultMyList.add(obj);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)))) {
            for (Skill resultObj : resultMyList) {
                writer.write(new String(resultObj.getId() + "," + resultObj.getName() + "\n"));
            }
        } catch (IOException e) {
            System.out.println("error writer i/o");
        }
        return skill;
    }

    private Skill parse(String str) {
        return new Skill(Long.valueOf(str.split(",+")[0]), str.split(",+")[1]);
    }
}
