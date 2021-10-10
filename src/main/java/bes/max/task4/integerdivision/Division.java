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

    public Division(int dividend, int divider) {
        super();
        this.dividend = dividend;
        this.divider = divider;
    }

    public void run() {
        absOfDividend = Math.abs(dividend);
        absOfDivider = Math.abs(divider);

        if (checkIfDividerIsNotNull(absOfDivider) & checkIfDividendIsNotNull(absOfDividend)) {
            while (dividend >= divider) {
                dividend = divide();
            }
        }
    }

    public int divide() {
        int lengthOfdDividend = countDigitsInInteger(dividend);
        int lengthOfdDivider = countDigitsInInteger(divider);
        int partOfDividend = trimNumber(dividend, (lengthOfdDividend - lengthOfdDivider));
        int remainder;

        if (partOfDividend >= divider) {
            partsOfDividends.add(partOfDividend);
            int multiplier = partOfDividend / divider;
            multipliers.add(multiplier);
            remainder = partOfDividend - (divider * multiplier);
            remainders.add(remainder);
            dividend = (int) (dividend - (multiplier * divider * Math.pow(10, (lengthOfdDividend - lengthOfdDivider))));

        } else {
            partOfDividend = trimNumber(dividend, (lengthOfdDividend - lengthOfdDivider - 1));
            partsOfDividends.add(partOfDividend);
            int multiplier = partOfDividend / divider;
            multipliers.add(multiplier);
            remainder = partOfDividend - (divider * multiplier);
            dividend = (int) (dividend
                    - (multiplier * divider * Math.pow(10, (lengthOfdDividend - lengthOfdDivider + 1))));
        }

        return dividend;

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
        
        return result;
        
    }

    public List<Integer> getMultipliers() {
        return multipliers;
    }

}
