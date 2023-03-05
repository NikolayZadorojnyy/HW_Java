//Вывести все простые числа от 1 до 1000
package task_2;

public class PrimeNumbers {
    public static void main(String[] args) {
        int i = 2;
        while (i <= 1000) {
            Integer res = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    res = null;
                    break;
                }
            }
            if (res != null) {
                System.out.println(res);
            }
            i++;
        }
    }
}
