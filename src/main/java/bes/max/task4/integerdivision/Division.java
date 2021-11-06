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

    public StringBuilder run() {
        absOfDividend = Math.abs(dividend);
        absOfDivider = Math.abs(divider);

        if (checkIfDividerIsNotNull(absOfDivider) & checkIfDividendIsNotNull(absOfDividend)) {
            while (absOfDividend >= absOfDivider) {
                absOfDividend = divide();
            }
            if (absOfDividend > 0) {
                remainders.add(absOfDividend);
            }
        }
        return assembleResultAsAString();
    }

    public int divide() {
        int lengthOfdDividend = countDigitsInInteger(absOfDividend);
        int lengthOfdDivider = countDigitsInInteger(absOfDivider);
        int digitsForTrim = (lengthOfdDividend - lengthOfdDivider);
        int partOfDividend = trimNumber(absOfDividend, digitsForTrim);
        int remainder;
        int intermediateResult;

        if (partOfDividend < absOfDivider) {

            digitsForTrim = (lengthOfdDividend - lengthOfdDivider - 1);
            partOfDividend = trimNumber(absOfDividend, digitsForTrim);
        }

        partsOfDividends.add(partOfDividend);
        int multiplier = partOfDividend / absOfDivider;
        intermediateResult = absOfDivider * multiplier;
        remainder = partOfDividend - intermediateResult;
        remainders.add(remainder);
        intermediateResults.add(intermediateResult);
        multipliers.add(multiplier);
        addNullToResult(absOfDividend, digitsForTrim, partOfDividend, multiplier);
        absOfDividend = (int) (absOfDividend - (intermediateResult * Math.pow(10, digitsForTrim)));

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
        if (digitsForTrimming < 0) {
            result = number;
            multipliers.add(0);
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
        result.append(calculateSpaces(intermediateResults.get(0), partsOfDividends.get(0)));
        result.append(intermediateResults.get(0));

        result.append(calculateSpaces(intermediateResults.get(0), Math.abs(dividend)));
        result.append("|");
        for (int eachMultiplier : multipliers) {
            result.append(eachMultiplier);
        }
        result.append(System.lineSeparator());

        for (int i = 1; i < partsOfDividends.size(); i++) {
            result.append(" ");
            result.append(calculateSpaces(remainders.get(i), intermediateResults.get(i - 1)));
            result.append(partsOfDividends.get(i));
            result.append(System.lineSeparator());

            result.append(" ");
            result.append(calculateSpaces(remainders.get(i), intermediateResults.get(i - 1)));
            result.append(calculateSpaces(partsOfDividends.get(i), intermediateResults.get(i)));
            result.append(intermediateResults.get(i));
            result.append(System.lineSeparator());
        }
        // result.append(" ");
        result.append(calculateSpaces(intermediateResults.get(intermediateResults.size() - 1),
                remainders.get(remainders.size() - 1)));
        result.append(remainders.get(remainders.size() - 1));

        return result;

    }

    public StringBuilder calculateSpaces(int numberOne, int numberTwo) {
        StringBuilder spaces = new StringBuilder("");
        int difference = Math.abs(countDigitsInInteger(numberOne) - countDigitsInInteger(numberTwo));

        for (int i = 0; i < difference; i++) {
            spaces.append(" ");
        }
        return spaces;
    }

    public void addNullToResult(int absOfDividend, int digitsForTrimming, int partOfDividend, int multiplier) {
        int remainderOfCurrentPartOfDividendPlusNextFigure = absOfDivider;
        if (digitsForTrimming > 0) {
            remainderOfCurrentPartOfDividendPlusNextFigure = Integer
                    .parseInt(Integer.toString(partOfDividend - (absOfDivider * multiplier)) + String
                            .valueOf((Integer.toString(absOfDividend)).charAt(countDigitsInInteger(absOfDivider))));
        }
        if (remainderOfCurrentPartOfDividendPlusNextFigure < absOfDivider) {
            multipliers.add(0);
        }

    }

    public List<Integer> getMultipliers() {
        return multipliers;
    }

    public List<Integer> getRemainders() {
        return remainders;
    }

    public List<Integer> getPartsOfDividends() {
        return partsOfDividends;
    }

    public List<Integer> getIntermediateResults() {
        return intermediateResults;
    }

}
