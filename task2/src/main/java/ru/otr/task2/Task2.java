package ru.otr.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task2 {

    private static String PHONE_LIST = "" +
        "Иванов И.И. +8 800 2000 500 +8 800 200 600\n" +
        "Петров П.П. +8 800 2000 700\n" +
        "Сидоров С.С. +8 800 2000 800 +8 800 2000 900 +8 800 2000 000";
    public static void main(String args[]) {
        String lines[] = PHONE_LIST.split("\\n");
        HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();
        for(int i = 0; i < lines.length; i++) {
            String[] atoms = lines[i].split("\\+");
            String name = atoms[0].trim();
            ArrayList phoneList = new ArrayList();
            for(int j = 1; j < atoms.length; j++) {
                phoneList.add("+" + atoms[j].trim());
            }
            phoneMap.put(name, phoneList);
        }

        String name = "Сидоров С.С.";

        displayPhoneList(name, phoneMap);

    }

    private static void displayPhoneList(String name, HashMap<String, ArrayList<String>> phoneMap) {

        ArrayList<String> phoneList = phoneMap.get(name);
        if(phoneList == null) {
            System.out.println("такого ФИО в БД нет");
        } else {
            for(int i = 0; i < phoneList.size(); i++) {
                System.out.println((i+1) + ". " + phoneList.get(i));
            }
        }

    }

}
