package bes.max.task4.integerdivision;

public class Main {

    public static void main(String[] args) {
        Division division = new Division(152000, 100);
        //division.divide(3, 0);
        System.out.println(division.run());
        System.out.println(division.getPartsOfDividends());

    }

}
