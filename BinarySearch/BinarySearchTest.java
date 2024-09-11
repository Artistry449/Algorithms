package BinarySearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFromFile() throws IOException {
        BinarySearch_Recursive binarySearch = new BinarySearch_Recursive();
        BufferedReader reader = new BufferedReader(new FileReader("BinarySearchData.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");

            // Parse array
            String[] arrStr = parts[0].trim().split(",");
            int[] arr = new int[arrStr.length];
            for (int i = 0; i < arrStr.length; i++) {
                arr[i] = Integer.parseInt(arrStr[i].trim());
            }

            int key = Integer.parseInt(parts[1].trim());

            int expectedResult = Integer.parseInt(parts[2].trim());

            int actualResult = binarySearch.binarySearch(arr, key, 0, arr.length - 1);

            assertEquals(expectedResult, actualResult, "Binary search failed for input: " + Arrays.toString(arr) + " and key: " + key);
        }

        reader.close();
    }
}
