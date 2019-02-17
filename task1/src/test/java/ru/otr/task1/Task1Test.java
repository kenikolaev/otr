package ru.otr.task1;

import org.junit.Assert;
import org.junit.Test;

public class Task1Test extends Assert {

    @Test
    public void testGetIPRange() {
        String expected =   "192.255.255.253\n" +
                            "192.255.255.254\n" +
                            "192.255.255.255\n" +
                            "193.0.0.0\n" +
                            "193.0.0.1\n" +
                            "193.0.0.2\n" +
                            "193.0.0.3\n";
        assertEquals(expected, Task1.getIPRange("192.255.255.252", "193.0.0.4"));

        String result = Task1.getIPRange("192.254.254.252", "193.1.2.4");
        assertTrue(result.contains("192.255.255.255") &&
                            result.contains("193.0.0.0") &&
                            result.contains("192.254.254.253") &&
                            result.contains("193.1.2.3"));
    }

}
