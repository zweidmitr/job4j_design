package ru.job4j;

public class ZB {
    public static void main(String[] args) {
        System.out.println(binary(123));
        System.out.println("---------------------");
        int x = 123;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(~x));
        System.out.println("---------------------");

        int a = 64;
        int b = 3;
        int c = (a << b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(c);
        System.out.println("---------------------");
        b = 4;
        int d = (a << b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(d));
        System.out.println(d);
        System.out.println("---------------------");
        System.out.println(111111111 << 1);
        System.out.println(111111111 << 2);
        System.out.println(111111111 << 3);
        System.out.println("---------------------");
        System.out.println(78 >>> 3);
        System.out.println("---------------------");

    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }
}
