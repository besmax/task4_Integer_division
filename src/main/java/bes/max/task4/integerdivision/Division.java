package bes.max.task4.integerdivision;

public class Division {

    private Console console = new DefaultConsole();
    private StringBuilder result = new StringBuilder();

    public int divide(int dividend, int divider) {
        int result = 0;
        int absOfDividend = Math.abs(dividend);
        int absOfDivider = Math.abs(divider);

        if (checkIfDividerIsNotNull(absOfDivider) & checkIfDividendIsNotNull(absOfDividend)) {
            if ((countDigitsInInteger(absOfDividend) == countDigitsInInteger(absOfDivider)
                    & absOfDividend >= absOfDivider)) {
                
            }
        }
        return result;

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

}
