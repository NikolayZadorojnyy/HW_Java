/*
Реализовать алгоритм сортировки слиянием
*/
package task_1;

public class Task_1 {

    public static void main(String[] args) {
        int[] array;
        array = FillRandomArray(10);                       // генерируем массив из 10 элементов
        System.out.println("Исходный ммассив: ");
        for(int element: array) {
            System.out.printf("%d ", element);
        }
        mergeSort(array, 10);
        System.out.println();
        System.out.println("Сортированый массив: ");
        for(int element: array) {
            System.out.printf("%d ", element);
        }

    }
    // создание рандомного массива из n элементов
    public static int[] FillRandomArray(int n) {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = ((int)(Math.random()*100));           // диапазон генерации от 0 до 99
        }
        return arr;
    }
    // функция разбивает массив в виде дерева и собирает обратно в сортированном виде
    public static void mergeSort(int [] arr, int n){
        if (n<2) return;                                   // выход из рекурсии
        int mid = n/2;
        int [] leftArr = new int[mid];                     // создаем два половинчатых массива
        int [] rightArr = new int[n-mid];                  //
        System.arraycopy(arr, 0, leftArr, 0, mid);         // исходный массив делим пополам
        System.arraycopy(arr, mid, rightArr, 0, n - mid);  // и копируем в два массива
        mergeSort(leftArr, mid);                           // рекурсивный вызов функции
        mergeSort(rightArr, n - mid);                      //
        merge(arr, leftArr, rightArr, mid, n - mid);
    }

    // функция сборки элементов разбитого массива в сортированном виде
    public static void merge(int[] arr, int[] leftArr, int [] rightArr, int leftLength, int rightLength){
        int k=0, i=0, j=0;
        while (i < leftLength && j < rightLength){
            if(leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i < leftLength){
            arr[k++] = leftArr[i++];
        }
        while (j < rightLength){
            arr[k++] = rightArr[j++];
        }
    }
}