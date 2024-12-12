package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals(quit)) {
                    // Convert both numbers to decimal
                    int value1 = Ex1.number2Int(num1);
                    int value2 = Ex1.number2Int(num2);

                    // Display the decimal values
                    System.out.println("Decimal value of number#1: " + value1);
                    System.out.println("Decimal value of number#2: " + value2);

                    // Check if the two numbers are equal
                    if (Ex1.equals(num1, num2)) {
                        System.out.println("The two numbers are equal.");
                    } else {
                        System.out.println("The two numbers are not equal.");
                    }

                    // Get the base of the first number for conversion
                    String[] parts1 = num1.split("b");
                    int base1 = Integer.parseInt(parts1[1], 16); // Convert base from hex to decimal

                    // Convert the decimal value of number#1 back to a string in its original base
                    String convertedBack = Ex1.int2Number(value1, base1);
                    System.out.println("Converted back number#1 in its original base: " + convertedBack);
                }
            }
        }
        System.out.println("Quitting now...");
        sc.close();
    }
}