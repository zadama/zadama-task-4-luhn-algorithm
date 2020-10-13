package se.experis.com;

public class LuhnAlgorithm {
    public static boolean luhnAlgorithm(Long number) {
        boolean isValid = true;
        int checksum = getChecksumValue(number);
        String stringNumber = getCardNumber(number);
        int sum = 0;
        int tempNumber;
        int steps = 0;
        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            if (steps % 2 == 0) {
                tempNumber = Character.getNumericValue(stringNumber.charAt(i)) * 2;
                if (tempNumber >= 10) {
                    tempNumber -= 9;
                }
                sum += tempNumber;
            }
            else {
                sum += Character.getNumericValue(stringNumber.charAt(i));
            }
            steps++;
        }
        sum *= 9;
        if (sum % 10 != checksum) {
            isValid = false;
        }
        return isValid;
    }

    public static int getChecksumValue (Long number) {
        return (int)(number % 10);
    }

    public static String getCardNumber(Long number) {
        String stringNumber = Long.toString(number);
        return stringNumber.substring(0, stringNumber.length() - 1);
    }

    public static int getNumberOfDigits(Long number) {
        return Long.toString(number).length();
    }

    public static boolean isCreditCard(Long number) {
        String stringNumber = Long.toString(number);
        if (stringNumber.length() == 16) {
            return true;
        }
        else {
            return false;
        }
    }
}
