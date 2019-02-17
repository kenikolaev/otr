package ru.otr.task2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Task2Test extends Assert {

    private final Map<String, String> testData = new HashMap<>();

    @Before
    public void setUpTestData() {
        testData.put("Иванов И.И.", "1. +8 800 2000 500\n2. +8 800 200 600\n");
        testData.put("Петров П.П.", "1. +8 800 2000 700\n");
        testData.put("Сидоров С.С.", "1. +8 800 2000 800\n2. +8 800 2000 900\n3. +8 800 2000 000\n");
        testData.put("Николаев Н.Н.", "Данное ФИО в Базе Данных отсуствует");
    }

    @After
    public void tearDownTestData() {
        testData.clear();
    }

    @Test
    public void testGetPhoneList() {
        Task2 task2 = new Task2();
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            final String testData = entry.getKey();
            final String expected = entry.getValue();
            final String actual = task2.getPhoneList(testData);
            assertEquals(expected, actual);
        }
    }

}
