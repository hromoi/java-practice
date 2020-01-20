import java.io.*;
import java.util.ArrayList;

public class SkillRepository {
    public static ArrayList<String> inputStream(){
        ArrayList<String> data = new ArrayList<>();
        String temp;
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt")))){
            do {
                temp = bufferReader.readLine();
                if (temp !=  null){
                    data.add(temp);
                }
            } while (temp != null);
        } catch (IOException e){
            System.out.println("Ошибка ввода/вывода");
        } catch (NullPointerException e3){
            System.out.println("Ошибка нулевой ссылки");
        }
        return data;
    }

    public static void outputStream(ArrayList<String> data){
        try (BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/IdeaProjects/first_crud_application/src/skill.txt", true)))){
            for (int i = 0; i < data.size(); i++)
                bufferWriter.write(data.get(i));
        } catch (IOException e2){
            System.out.println("Ошибка ввода/вывода2");
        }
    }
}
