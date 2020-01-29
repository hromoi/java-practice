package controller;

import model.SkillModelImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SkillController {
    public static String str;

    public static void main(String[] args) {
        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))){
            SkillModelImpl skillModel = new SkillModelImpl();
            skillModel.service(buffer.readLine());
        } catch (Exception e){
            System.out.println("error " + e);
        }
    }
}
