package se.experis.com;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgorithmTest {

    private long validInput = 4242424242424242L;

    @org.junit.jupiter.api.Test
    void validLuhnAlgorithm() {

        assertTrue(LuhnAlgorithm.luhnAlgorithm(validInput));
    }

    @org.junit.jupiter.api.Test
    void invalidLuhnAlgorithm() {

        Long invalidInput = 4242424242424252L;
        // This should result in the algorithm returning false
        // because we replaced the last digit(not the check digit)
        // with 5, which makes total sum = 73.
        // (73 % 10 == 0) will return false.
        assertFalse(LuhnAlgorithm.luhnAlgorithm(invalidInput));
    }

    @org.junit.jupiter.api.Test
    void getChecksumValue() {
        String convertedValidInput = Long.toString(validInput);
        String lastDigit = convertedValidInput.substring(convertedValidInput.length()-1);
        long lastDigitAsLong = Long.parseLong(lastDigit);

        //Last digit of the validInput is 2, which we will expect.
        assertEquals(2,LuhnAlgorithm.getChecksumValue(lastDigitAsLong));
        // Used to test cases where the input value is 0 or less than 0;
        assertEquals(0,LuhnAlgorithm.getChecksumValue(0L));
        assertEquals(-2,LuhnAlgorithm.getChecksumValue(-2L));


    }

    @org.junit.jupiter.api.Test
    void getCardNumber() {
        //With valid input. More than one digit.
        assertEquals("424242424242424",LuhnAlgorithm.getCardNumber(validInput));
        // If one digit is sent as an argument.
        assertEquals("",LuhnAlgorithm.getCardNumber(1L));

    }

    @org.junit.jupiter.api.Test
    void getNumberOfDigits() {
        assertEquals(16,LuhnAlgorithm.getNumberOfDigits(validInput));
    }

    @org.junit.jupiter.api.Test
    void isCreditCard() {

            assertTrue(LuhnAlgorithm.isCreditCard(validInput));
    }

    @org.junit.jupiter.api.Test
    void isNotACreditCard() {
        //Less than 16
        assertFalse(LuhnAlgorithm.isCreditCard(4242424L));
        //More than 16
        assertFalse(LuhnAlgorithm.isCreditCard(424242424242424252L));
    }
}