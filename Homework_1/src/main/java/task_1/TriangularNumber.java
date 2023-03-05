/*
Вычислить n-ое треугольного число(сумма чисел от 1 до n),
а так же n! (произведение чисел от 1 до n)
Ввод:5
Треугольное число 1 + 2 + 3 + 4 + 5 = 15
n! 1 * 2 * 3 * 4 * 5 = 120
*/
package task_1;

import java.util.Scanner;

public class TriangularNumber {
    public static void main(String[] args) {
        System.out.println("Введите число n:");
        var i = new Scanner(System.in).nextInt();
        new Scanner(System.in).close();
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum = sum + j;
        }
        int fac = 1;
        for (int j = 1; j <= i; j++) {
            fac = fac * j;
        }

        System.out.printf("Сумма от 0 до n равна: %d\n", sum);
        System.out.printf("Факториал числа n равен: %d\n", fac);
    }
}
