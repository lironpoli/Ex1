package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
// Test for converting a number to a string in base 2
        String result = Ex1.int2Number(11, 2); // 11 in decimal to binary
        assertEquals("1011b2", result);  // 11 in decimal should convert to "1011b2"

        // Test for converting a number to a string in base 16
        result = Ex1.int2Number(31, 16);  // 31 in decimal to hexadecimal
        assertEquals("1Fb10", result);  // 31 in decimal should convert to "1F" in hexadecimal

        // Test for invalid base, should return an empty string
        result = Ex1.int2Number(-5, 2);  // Invalid number (negative)
        assertEquals("", result);  // Should return empty string

        result = Ex1.int2Number(5, 20);  // Invalid base (greater than 16)
        assertEquals("", result);  // Should return empty string    }
    }
    @Test
    void maxIndexTest() {
// Create an array of numbers as strings
            String[] numbers = {"101b2", "11b2", "1111b2", "100b2", "1001b2"};

            // Convert them to integers for comparison
            int[] values = {
                    Ex1.number2Int("101b2"),  // 5 in decimal
                    Ex1.number2Int("11b2"),   // 3 in decimal
                    Ex1.number2Int("1111b2"), // 15 in decimal
                    Ex1.number2Int("100b2"),  // 4 in decimal
                    Ex1.number2Int("1001b2")  // 9 in decimal
            };

            // Get the index of the largest number using maxIndex
            int index = Ex1.maxIndex(numbers);

            // Assert that the index corresponds to the largest number (i.e., 1111b2 -> 15 in decimal)
            assertEquals(2, index);  // The index of "1111b2" in the array is 2
        }
    @Test
    void maxIndexWithInvalidInputsTest() {
        // Create an array with valid and invalid numbers as strings
        String[] numbers = {"101b2", "invalid", "100b2", "0bA", " ", null, "1111b2"};

        // Convert the valid numbers to integers
        int[] values = {
                Ex1.number2Int("101b2"),  // 5 in decimal
                Ex1.number2Int("100b2"),  // 4 in decimal
                Ex1.number2Int("0bA"),    // 10 in decimal
                Ex1.number2Int("1111b2")  // 15 in decimal
        };

        // Handle invalid numbers that would convert to -1 (invalid format)
        int[] expectedValues = {5, -1, 4, 10, -1, -1, 15};  // -1 for invalid inputs

        // Ensure the array contains the expected values, checking against valid/invalid inputs
        int index = Ex1.maxIndex(numbers);

        // We expect that the largest valid number is "1111b2" with a decimal value of 15, so the index should be 6
        assertEquals(6, index);  // Index of "1111b2" should be the largest valid number
    }
}
