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
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals(quit)) break;

            if (!Ex1.isNumber(num1)) {
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            }

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) break;

            if (!Ex1.isNumber(num2)) {
                System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue;
            }

            // Convert both numbers to decimal
            int value1 = Ex1.number2Int(num1);
            int value2 = Ex1.number2Int(num2);

            // Display the decimal values
            System.out.println("Decimal value of number#1: " + value1);
            System.out.println("Decimal value of number#2: " + value2);

            // Compute sum and product
            int sum = value1 + value2;
            int product = value1 * value2;

            // Display the sum and product
            System.out.println("Sum of the two numbers: " + sum);
            System.out.println("Product of the two numbers: " + product);

            // Convert the decimal value of number#1 back to a string in its original base
            String[] parts1 = num1.split("b");
            int base1 = Integer.parseInt(parts1[1], 16); // Convert base from hex to decimal
            String convertedBack1 = Ex1.int2Number(value1, base1);

            // Convert the decimal value of number#2 back to a string in its original base
            String[] parts2 = num2.split("b");
            int base2 = Integer.parseInt(parts2[1], 16); // Convert base from hex to decimal
            String convertedBack2 = Ex1.int2Number(value2, base2);

            // Display the original numbers converted back
            System.out.println("Converted back number#1 in its original base: " + convertedBack1);
            System.out.println("Converted back number#2 in its original base: " + convertedBack2);

            // Create an array to store the two numbers, their sum, and their product
            String[] numbersArray = new String[4];
            numbersArray[0] = num1;
            numbersArray[1] = num2;
            numbersArray[2] = Ex1.int2Number(sum, base1); // Sum in the same base as num1
            numbersArray[3] = Ex1.int2Number(product, base1); // Product in the same base as num1

            // Find the index of the largest number in the array using Ex1.maxIndex
            int maxIdx = Ex1.maxIndex(numbersArray);

            // Display the results
            System.out.println("Numbers and results array:");
            for (int i = 0; i < numbersArray.length; i++) {
                System.out.println("Index " + i + ": " + numbersArray[i]);
            }
            System.out.println("The index of the largest value in the array is: " + maxIdx);
        }

        System.out.println("Quitting now...");
        sc.close();
    }
}
