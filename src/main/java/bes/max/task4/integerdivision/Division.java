package bes.max.task4.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class Division {

    private Console console = new DefaultConsole();
    private StringBuilder result = new StringBuilder();
    private int absOfDividend;
    private int absOfDivider;
    private int dividend;
    private int divider;
    private List<Integer> multipliers = new ArrayList<>();
    private List<Integer> remainders = new ArrayList<>();
    private List<Integer> partsOfDividends = new ArrayList<>();
    private List<Integer> intermediateResults = new ArrayList<>();


    public Division(int dividend, int divider) {
        super();
        this.dividend = dividend;
        this.divider = divider;
    }

    public void run() {
        absOfDividend = Math.abs(dividend);
        absOfDivider = Math.abs(divider);

        if (checkIfDividerIsNotNull(absOfDivider) & checkIfDividendIsNotNull(absOfDividend)) {
            while (absOfDividend >= absOfDivider) {
                absOfDividend = divide();
            }
        }
    }

    public int divide() {
        int lengthOfdDividend = countDigitsInInteger(absOfDividend);
        int lengthOfdDivider = countDigitsInInteger(absOfDivider);
        int partOfDividend = trimNumber(absOfDividend, (lengthOfdDividend - lengthOfdDivider));
        int remainder;

        if (partOfDividend >= absOfDivider) {
            partsOfDividends.add(partOfDividend);
            int multiplier = partOfDividend / absOfDivider;
            multipliers.add(multiplier);
            remainder = partOfDividend - (absOfDivider * multiplier);
            remainders.add(remainder);
            intermediateResults.add(absOfDivider * multiplier);
            absOfDividend = (int) (absOfDividend - (multiplier * absOfDivider * Math.pow(10, (lengthOfdDividend - lengthOfdDivider))));

        } else {
            partOfDividend = trimNumber(absOfDividend, (lengthOfdDividend - lengthOfdDivider - 1));
            partsOfDividends.add(partOfDividend);
            int multiplier = partOfDividend / absOfDivider;
            multipliers.add(multiplier);
            remainder = partOfDividend - (absOfDivider * multiplier);
            remainders.add(remainder);
            intermediateResults.add(absOfDivider * multiplier);
            absOfDividend = (int) (absOfDividend
                    - (multiplier * absOfDivider * Math.pow(10, (lengthOfdDividend - lengthOfdDivider + 1))));
        }

        return absOfDividend;

    }

    public boolean checkIfDividerIsNotNull(int divider) {
        if (divider == 0) {
            console.print("Divider can not be null");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIfDividendIsNotNull(int dividend) {
        if (dividend == 0) {
            console.print("Dividend is 0, so result is 0");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIfDividerIsMoreThanDividend(int dividend, int divider) {
        if (Math.abs(dividend) >= Math.abs(divider)) {
            return true;
        } else {
            return false;
        }
    }

    public int countDigitsInInteger(int number) {
        if (number == 0) {
            return 1;
        }
        return (int) (Math.log10(number) + 1);
    }

    public int trimNumber(int number, int digitsForTrimming) {
        int result;
        if (digitsForTrimming <= 0) {
            result = number;
        } else {
            result = (int) (number / Math.pow(10, digitsForTrimming));
        }
        return result;
    }
    
    public StringBuilder assembleResultAsAString() {
        result.append(Math.abs(dividend));
        result.append("|");
        result.append(absOfDivider);
        result.append(System.lineSeparator());
        result.append(intermediateResults.get(0));
        result.append(calculateSpaces(intermediateResults.get(0), dividend));
        
        return result;
        
    }
    
    public StringBuilder calculateSpaces(int numberOne, int numberTwo) {
        StringBuilder spaces = new StringBuilder();
        int difference = Math.abs(countDigitsInInteger(numberOne) - countDigitsInInteger(numberTwo));
        
        for (int i = 0; i < difference; i++) {
         spaces.append(" ");   
        }
        return spaces;
    }

    public List<Integer> getMultipliers() {
        return multipliers;
    }

}
