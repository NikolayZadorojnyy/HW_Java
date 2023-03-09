/*
Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации (после перемещения числа) запишите в лог-файл.
*/
package task_1;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BubbleSortLog {
    public static void main(String[] args) throws IOException {
        int[] arr = {5, 23, 56, 3, 9, 0, 32, 7, 12, 45, 5, 2, 45};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Отсортированный массив: " + Arrays.toString(bubleSort(arr)));
    }

    public static int[] bubleSort(int some_arr[]) throws IOException{
        Logger logger = Logger.getLogger(BubbleSortLog.class.getName());
        FileHandler fh = new FileHandler("bubleSort_log.txt",false); // false перезаписывать заново
        logger.setUseParentHandlers(false); // не выводить в консоль
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.info("Логгирование каждой итеррации пузырьковой сортировки.");
        int count = 0;
        int temp;
        for (int i = 0; i < some_arr.length - 1; i++) {
            for (int j = 0; j < some_arr.length - 1; j++) {
                if (some_arr[j] > some_arr[j + 1]) {
                    temp = some_arr[j];
                    some_arr[j] = some_arr[j + 1];
                    some_arr[j + 1] = temp;
                    count++;
                    logger.info("Шаг => | "+ count + " | " + Arrays.toString(some_arr));
                }
            }
        }
        return some_arr;
    }
}
