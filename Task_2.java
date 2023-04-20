/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после
 * каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;

 public class Task_2 {
    public static void main(String[] args) {
 
        int[] arr = new int[] {3, 7, 1, 6, 3, 5, 12, 9, 8};
        bubble_sort(arr);
    }

    static void bubble_sort(int[] array) {
        int size = array.length;

        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log2.txt");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                logger.log(Level.INFO, Arrays.toString(array));
            }
        }
        fileHandler.close();
    }
}

