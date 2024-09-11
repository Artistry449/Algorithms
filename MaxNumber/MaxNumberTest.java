package MaxNumber;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MaxNumberTest {

    MaxNumber maxNumber = new MaxNumber();

    @Test
    void testMaxNumberFromFile() {
        String testDataFilePath = "MaxNumberData.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(testDataFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split("\\|");
                String[] arrayString = parts[0].split(",");
                int[] arr = new int[arrayString.length];

                for (int i = 0; i < arrayString.length; i++) {
                    arr[i] = Integer.parseInt(arrayString[i].trim());
                }

                int expectedResult = Integer.parseInt(parts[1].trim());

                assertEquals(expectedResult, maxNumber.searchMaxNumber(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testEmptyArray(){
        int[] arr = {};
        assertEquals(-1, maxNumber.searchMaxNumber(arr));
    }

    @Test 
    void testArrayWithOneValue(){
        int[] arr = {1};

        assertEquals(1, maxNumber.searchMaxNumber(arr));
    }

    @Test
    void testMaxNumberWithMixedNumbers() {
        int[] arr = { -100, 0, 200, -300, 150 };
        assertEquals(200, maxNumber.searchMaxNumber(arr));
    }

}
