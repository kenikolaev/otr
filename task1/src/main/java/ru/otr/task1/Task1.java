package ru.otr.task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String argS[]) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первый IP адрес: ");
        String input1 = in.next();
        System.out.println("Введите второй IP адрес: ");
        String input2 = in.next();
        System.out.println("Диапазон IP адресов: ");
        System.out.println(getIPRange(input1, input2));
    }

    public static String getIPRange(String from, String to) {
        StringBuilder result = new StringBuilder();
        long numberOfIPs = ipToLong(to) - ipToLong(from) - 1;
        int[] currentIP = getArrayFromIP(from);

        for(long i = 0; i < numberOfIPs; i++) {
            currentIP[3]++;
            checkIfOutOfRange(currentIP);
            result.append(currentIP[0] + "." + currentIP[1] + "." + currentIP[2] + "." + currentIP[3] + "\n");
        }

        return result.toString();
    }

    private static void checkIfOutOfRange(int[] ip) {
        for(int i = 3; i > 0; i--) {
            if(ip[i] == 256) {
                ip[i-1]++;
                ip[i] = 0;
            } else break;
        }
    }

    private static int[] getArrayFromIP(String ipAddress) {
        int[] result = new int[4];
        String[] atoms = ipAddress.split("\\.");

        for (int i = 0; i < 4; i++) {
            result[i] = Integer.parseInt(atoms[i]);
        }

        return result;
    }

    private static long ipToLong(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }

        return result;
    }

}
