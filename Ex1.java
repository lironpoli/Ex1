import String

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;

    package assignments.ex1;
    /**
     * This class represents a simple solution for Ex1.
     * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
     * In this assignment, we will design a number formatting converter and calculator.
     * In general, we will use Strings as numbers over basis of binary till Hexa.
     * [2-16], 10-16 are represented by A,B,..G.
     * The general representation of the numbers is as a String with the following format:
     * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
     * The following are NOT in the format (not a valid number):
     * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
     * You should implement the following static functions:
     */
    public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            if(!isNumber(num)) //checks if the number is valid format
                return ans;

            String[] parts = num.split("b");
            String numPart = parts[0];
            int base = Integer.parseInt(parts[1], 16); //convert base from hexa-decimal to decimal representation


            int DecimalValue = 0;
            for (int i = 0; i < numPart.length(); i++) {
                char digit = numPart.charAt(i);
                int DigitValue = 0;
                if (Character.isDigit(digit)) {
                    DigitValue = digit - '0'; // Convert char to int
                } else {
                    DigitValue = Character.toUpperCase(digit) - 'A' + 10; // convert A-F to 10-15
                }
                DecimalValue = DecimalValue * base + digitValue; // convert to decimal
            }
            return DecimalValue;
        }

    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a == null || a.isEmpty() || a.contains(" ") || a.startsWith("b") || a.contains("b0") || a.contains("b1") || a.contains("b10") || a.contains("b11") || a.contains("b12") || a.contains("b13") || a.contains("b14") || a.contains("b15") || a.contains("b16"))
            ans = false;
        if(a.contains("b10" || "b11" || "b12" || "b13" || "b14" || "b15" || "b16"))
            ans = false;
        if(a.indexOf("b") == 0)
            ans = false;

        if(a.matches("^[0-9A-F]+b[2-9A-F]$"); //check if it matches the valid format

        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if(num < 0 || base < 2 || base > 16)
            return ans;

        StrBuilder result = new StrBuilder();
        do {
            int remainder = num % base;
            if (remainder < 10) {
                result.append(remainder);
            } else {
                result.append((char) ('A' + (remainder - 10))); // Convert to A-F for 10-15
            }
            num /= base;
        } while (num > 0);

        return result.reverse().toString() + "b" + Integer.toHexString(base).toUpperCase();
    }

}

/**
 * Checks if the two numbers have the same value.
 * @param n1 first number
 * @param n2 second number
 * @return true iff the two numbers have the same values.
 */
public static boolean equals(String n1, String n2) {
    boolean ans = true;
    if(n1 == n2)
        ans = true;
    if (n1 != n2)
        ans = false;

    return ans;
}

/**
 * This static function search for the array index with the largest number (in value).
 * In case there are more than one maximum - returns the first index.
 * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
 * @param arr an array of numbers
 * @return the index in the array in with the largest number (in value).
 *
 */
public static int maxIndex(String[] arr) {
    int ans = 0;
    int maxValue = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
        int value = Ex1.number2Int(arr[i]);
        if (value > maxValue) {
            maxValue = value;
        }
    }
    ans = maxValue;
    ////////////////////
    return ans;
}

            }
                    }
