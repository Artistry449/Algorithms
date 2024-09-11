package InsertionSort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestDataGenerator {

    public static void main(String[] args) throws IOException {
        generateTestData("InsertionSortInput.txt", "InsertionSortOutput.txt", 100, 10);
    }

    public static void generateTestData(String inputFileName, String outputFileName, int numArrays, int arraySize) throws IOException {
        Random random = new Random();
        BufferedWriter inputWriter = new BufferedWriter(new FileWriter(inputFileName));
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFileName));

        for (int i = 0; i < numArrays; i++) {
            int[] array = new int[arraySize];

            for (int j = 0; j < arraySize; j++) {
                array[j] = random.nextInt(10); 
            }

            writeArrayToFile(array, inputWriter);

            Arrays.sort(array);
            writeArrayToFile(array, outputWriter);
        }

        System.out.println("\n[InsertionSort] Тестний дата амжилттай бичигдлээ.\n");

        inputWriter.close();
        outputWriter.close();
    }

    private static void writeArrayToFile(int[] array, BufferedWriter writer) throws IOException {
        for (int i = 0; i < array.length; i++) {
            writer.write(array[i] + (i == array.length - 1 ? "\n" : " "));
        }
    }
}
