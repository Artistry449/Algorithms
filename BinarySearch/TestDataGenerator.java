package BinarySearch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator {

    public static void main(String[] args) {
        int numTestCases = 10;
        int maxArraySize = 10;

        generateTestData("BinarySearchData.txt", numTestCases, maxArraySize);
    }

    public static void generateTestData(String filename, int numTestCases, int maxArraySize) {
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numTestCases; i++) {

                int arraySize = random.nextInt(maxArraySize) + 1;
                int[] arr = new int[arraySize];
                arr[0] = random.nextInt(10); 

                for (int j = 1; j < arraySize; j++) {
                    arr[j] = arr[j - 1] + random.nextInt(10) + 1;
                }

                int targetIndex = random.nextInt(arraySize + 1);
                int target = (targetIndex < arraySize) ? arr[targetIndex] : arr[arraySize - 1] + random.nextInt(10) + 1;

                int expectedResult = (targetIndex < arraySize) ? targetIndex : -1;

                StringBuilder arrayStr = new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    arrayStr.append(arr[j]);
                    if (j < arr.length - 1) {
                        arrayStr.append(",");
                    }
                }

                writer.write(arrayStr.toString() + " | " + target + " | " + expectedResult + "\n");
            }

            System.out.println("\n[BinarySearch] Тестний дата амжилттай бичигдлээ.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
