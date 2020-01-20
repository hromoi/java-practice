import java.util.ArrayList;

public class Main {
    public static void print(ArrayList<String> myList){
        for (String str : myList) {
            System.out.print(str);
        }
    }

    public static void printObject(ArrayList<Skill> myAllObjectList){
        for (Skill obj : myAllObjectList) {
            System.out.println(obj);
        }
    }

    public static void readFile(ArrayList<String> skillList){
        ArrayList<String> strings = SkillRepository.inputStream();
        String[] data;
        String str = null;
        for (int i = 0; i < strings.size() - 1; i++){
            data = strings.get(i).split("[, ]|, +");
            if (data != null)
                str = data[0] + " " + data[1] + " " + data[2] + "\n";
            skillList.add(str);
        }
    }

    public static void writeFile(ArrayList<String> skillList){
        SkillRepository.outputStream(skillList);
    }

    public static void saveObject(ArrayList<String> skillList, ArrayList<Skill> allObject){
        for (int i = 0; i < skillList.size(); i++){
            String[] arrayData = skillList.get(i).split(" +");
            Skill skill = new Skill();
            skill.setId(Long.valueOf(arrayData[0]));
            skill.setName(arrayData[1]);
            skill.setEmail(arrayData[2]);
            allObject.add(skill);
        }
    }

    public static void main(String[] args){
        ArrayList<String> skillList = new ArrayList<>();
        ArrayList<Skill> allObject = new ArrayList<>();

        readFile(skillList);
        print(skillList);
        writeFile(skillList);
        print(skillList);
        saveObject(skillList, allObject);
        printObject(allObject);
    }
}