package bes.max.task4.integerdivision;

public class Main {

    public static void main(String[] args) {
        int dividend;
        int divider;
        Console console = new DefaultConsole();
        console.print("Enter dividend and press Enter");
        dividend = console.read();
        console.print("Enter dividend and press Enter");
        divider = console.read();
        Division division = new Division(dividend, divider);
        console.print(division.run().toString());
        
        console.print(division.getRemainders().toString());
        console.print(division.getIntermediateResults().toString());
        console.print(division.getPartsOfDividends().toString());
    }

}
