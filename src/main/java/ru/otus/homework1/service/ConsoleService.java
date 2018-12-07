package ru.otus.homework1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleService {

    public String getAnswer(String question){
        BufferedReader br;
        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print(question + " : ");
                return br.readLine();
            }
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public void print(Object object){
        System.out.println(object.toString());
    }

}
