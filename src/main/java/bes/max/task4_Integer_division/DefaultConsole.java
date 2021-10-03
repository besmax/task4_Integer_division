package bes.max.task4_Integer_division;

import java.util.Scanner;

public class DefaultConsole implements Console {

    public int read() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public void print(String input) {
        System.out.println(input);
    }

}
