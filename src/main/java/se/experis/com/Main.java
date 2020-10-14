package se.experis.com;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Long cardNumber;
        try {
            System.out.print("Please enter a creditcard number: ");
            cardNumber = myScanner.nextLong();
            if (cardNumber < 0) {
                throw new Exception("Invalid input: negative number.");
            }
            if (LuhnAlgorithm.luhnAlgorithm(cardNumber)) {
                System.out.println("Valid");
            }
            else {
                System.out.println("Invalid");
            }
            System.out.println("Creditcard number: " + LuhnAlgorithm.getCardNumber(cardNumber));
            System.out.println("Checksum: " + LuhnAlgorithm.getChecksumValue(cardNumber));
            System.out.println("Digits: " + LuhnAlgorithm.getNumberOfDigits(cardNumber) + " ( "  + (LuhnAlgorithm.isCreditCard(cardNumber) ? "credit card" : "not a credit card"  ) + " )");

        } catch (InputMismatchException e){
            System.out.println("Invalid input.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
