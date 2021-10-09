package bes.max.task4.integerdivision;

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
