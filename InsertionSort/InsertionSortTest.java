package InsertionSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import java.io.*;
import java.util.*;

public class InsertionSortTest {

    @Test
    public void testInsertionSortFromFile() throws IOException {
        InsertionSort sorter = new InsertionSort();
        
        List<int[]> inputArrays = readFile("InsertionSortInput.txt");
        List<int[]> expectedSortedArrays = readFile("InsertionSortOutput.txt");

        for (int i = 0; i < inputArrays.size(); i++) {
            int[] inputArray = inputArrays.get(i);
            int[] expectedArray = expectedSortedArrays.get(i);

            System.out.println("Testing array " + (i + 1));
            System.out.println("Input: " + Arrays.toString(inputArray));
            System.out.println("Expected: " + Arrays.toString(expectedArray)); 

            int[] sortedArray = sorter.sort(inputArray);

            assertArrayEquals(expectedArray, sortedArray);

        }
    }

    private List<int[]> readFile(String filename) throws IOException {
        List<int[]> arrays = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] stringNumbers = line.split(" ");
            int[] numbers = new int[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }
            arrays.add(numbers);
        }

        reader.close();
        return arrays;
    }
}
