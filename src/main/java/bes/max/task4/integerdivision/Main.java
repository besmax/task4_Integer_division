package bes.max.task4.integerdivision;

public class Main {

    public static void main(String[] args) {
        Division division = new Division(54836, 122);
        //division.divide(3, 0);
        division.run();
        System.out.println(division.getMultipliers().toString());
    }

}
