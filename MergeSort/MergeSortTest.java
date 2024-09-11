package MergeSort;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSortFromFile() throws IOException{
        MergeSort mergeSort = new MergeSort();

        List<int[]> inputArrays = readFile("SortAlgorithmInput.txt");
        List<int[]> expectedSortedArrays = readFile("SortAlgorithmOutput.txt");

        for(int i=0; i<inputArrays.size(); i++){
            int[] inputArray = inputArrays.get(i);
            int[] expectedArray = expectedSortedArrays.get(i);

            mergeSort.sort(inputArray, 0, inputArray.length - 1);

            assertArrayEquals(inputArray, expectedArray);
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
