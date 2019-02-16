package ru.otr.task1;

public class Task1 {

    public static void main(String argS[]) {
        printIPs("192.255.255.252", "193.0.1.11");
    }

    public static void printIPs(String from, String to) {
        long numberOfIPs = ipToLong(to) - ipToLong(from) - 1;
        int[] currentIP = getArrayFromIP(from);

        for(long i = 0; i < numberOfIPs; i++) {
            currentIP[3]++;
            checkIfOutOfRange(currentIP);
            System.out.println(currentIP[0] + "." + currentIP[1] + "." + currentIP[2] + "." + currentIP[3]);
        }

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

    public static long ipToLong(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }

        return result;
    }

}
