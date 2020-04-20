package stringUtils;

import java.util.Random;

public abstract class Util {

    public static String generate(int maxLength, char[] data) {
        StringBuilder r = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < maxLength; i++) {
            r.append(data[rnd.nextInt(data.length)]);
        }
        return r.toString();
    }

    public static String generate(int maxLength) {
        return generate(maxLength, BASE_DATA.toCharArray());
    }

    public static void main(String[] args) {
        int m = 12;
        int n = 8;
        for (int i = 0; i < n; i++) {
            System.out.println(generate(m));
        }
    }

    private static final String BASE_DATA
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            +"!@#$%^&*()_+";
}
