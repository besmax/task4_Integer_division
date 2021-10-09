package bes.max.task4.integerdivision;

public class Division {

    private Console console = new DefaultConsole();

    public int divide(int dividend, int divider) {
        int result = 0;
        int absOfDividend = Math.abs(dividend);
        int absOfDivider = Math.abs(divider);
        
        if (checkIfDividerIsNotNull(absOfDivider) & checkIfDividendIsNotNull(absOfDividend)) {
            
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
        int result = 0;
        while(number != 0) {
            number = number/10;
            result++;
        }
        return result;
    }

}
