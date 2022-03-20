package com.company;

import java.util.Scanner;

public class Main {
    public static int k = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            String s = sc.next();
            String p = sc.next(); // that Barbara has entered
            // int i = 0;
            int j = 0;
            int count = 0;
            int m = 0;
            for (int i = 0; i < s.length(); ) {
                if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    m++;
                } else {
                    j++;
                    count++;
                }
            }

            System.out.println("Case #" + k + ": " + count);
            k++;
        }
    }
}
