import java.lang.String;
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
            int base = Character.isDigit(parts[1].charAt(0)) ? Integer.parseInt(parts[1]) : (parts[1].charAt(0) - 'A' + 10);

            int decimalValue = 0;
            for (int i = 0; i < numPart.length(); i++) {
                char digit = numPart.charAt(i);
                int digitValue = Character.isDigit(digit) ? digit - '0' : (Character.toUpperCase(digit) - 'A' + 10);

                if (digitValue >= base) return -1; // Invalid digit for the base
                decimalValue = decimalValue * base + digitValue;
            }
            return decimalValue;
        }

        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            if (a == null || a.isEmpty())
                return false;

            String[] parts = a.split("b");
            if (parts.length != 2) return false;

            String numPart = parts[0];
            String basePart = parts[1];

            // Check base format
            int base;
            if (basePart.length() == 1 && Character.isDigit(basePart.charAt(0))) {
                base = Integer.parseInt(basePart);
            } else if (basePart.length() == 1 && basePart.charAt(0) >= 'A' && basePart.charAt(0) <= 'G') {
                base = basePart.charAt(0) - 'A' + 10;
            } else {
                return false;
            }

            if (base < 2 || base > 16) return false;

            // Check numPart validity
            for (char c : numPart.toCharArray()) {
                int value = Character.isDigit(c) ? c - '0' : (Character.toUpperCase(c) - 'A' + 10);
                if (value < 0 || value >= base) return false;
            }

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

            StringBuilder result = new StringBuilder();
            do {
                int remainder = num % base;
                if (remainder < 10) {
                    result.append(remainder);
                } else {
                    result.append((char) ('A' + (remainder - 10)));
                }
                num /= base;
            } while (num > 0);

            String baseSuffix = base <= 10 ? Integer.toString(base) : String.valueOf((char) ('A' + (base - 10)));
            return result.reverse().toString() + "b" + baseSuffix;
        }

        /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if(n1.equals(n2))
            return ans ;
        if (!n1.equals(n2))
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


