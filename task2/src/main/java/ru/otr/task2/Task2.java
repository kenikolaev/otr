package ru.otr.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    private static String PHONE_LIST = "" +
        "Иванов И.И. +8 800 2000 500 +8 800 200 600\n" +
        "Петров П.П. +8 800 2000 700\n" +
        "Сидоров С.С. +8 800 2000 800 +8 800 2000 900 +8 800 2000 000";

    private HashMap<String, ArrayList<String>> phoneMap;

    public Task2() {
        String lines[] = PHONE_LIST.split("\\n");
        phoneMap = new HashMap<>();
        for(int i = 0; i < lines.length; i++) {
            String[] atoms = lines[i].split("\\+");
            String name = atoms[0].trim();
            ArrayList phoneList = new ArrayList();
            for(int j = 1; j < atoms.length; j++) {
                phoneList.add("+" + atoms[j].trim());
            }
            phoneMap.put(name, phoneList);
        }
    }

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in, "Cp866" ).useDelimiter("\\r\\n");
        System.out.println("Введите ФИО: ");
        String input = in.next();
        System.out.println(new Task2().getPhoneList(input));
    }

    public String getPhoneList(String name) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> phoneList = phoneMap.get(name);
        if(phoneList == null) {
            result.append("Данное ФИО в Базе Данных отсуствует");
        } else {
            for(int i = 0; i < phoneList.size(); i++) {
                result.append((i+1) + ". " + phoneList.get(i) + "\n");
            }
        }

        return result.toString();

    }

}
