package bes.max.task4.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionTest {

    Division divisionForTest = new Division(54836, 122);
    
    @Test
    void checkIfDividendIsNotNullReturnTrueIfDividendIsNotNull() {
        assertTrue(divisionForTest.checkIfDividendIsNotNull(4));
    }
    
    @Test
    void checkIfDividendIsNotNullReturnsFalseIfDividendIsNull() {
        assertFalse(divisionForTest.checkIfDividendIsNotNull(0));
    }
    
    @Test
    void checkIfDividerIsNotNullReturnsTrueIfDividerIsNotNull() {
        assertTrue(divisionForTest.checkIfDividerIsNotNull(4));
    }
    
    @Test
    void checkIfDividerIsNotNullReturnsFalseIfDividerIsNull() {
        assertFalse(divisionForTest.checkIfDividerIsNotNull(0));
    }
    
    @Test
    void countDigitsInIntegerReturnsCorrectNumber() {
        assertEquals(divisionForTest.countDigitsInInteger(458), 3);
        assertEquals(divisionForTest.countDigitsInInteger(1), 1);
        assertEquals(divisionForTest.countDigitsInInteger(2312352), 7);
        assertEquals(divisionForTest.countDigitsInInteger(0), 1);
    }
    
    @Test
    void trimNumberReturnsCorrectNumber() {
        assertEquals(divisionForTest.trimNumber(187469, 2), 1874);
        assertEquals(divisionForTest.trimNumber(1874, 0), 1874);
        assertEquals(divisionForTest.trimNumber(1874, -9), 1874);


    }

}
