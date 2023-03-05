/*
Реализовать простой калькулятор (+ - / *)
Ввод числа ->
Ввод знака ->
Ввод числа ->
*/
package task_3;

import java.util.Scanner;

public class MiniCalc {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        double a = getDouble();
        double b = getDouble();
        char op = getOperation();
        scaner.close();
        if (!(op == '+' || op == '-' || op == '*' || op == '/')) {
            System.out.println("Некорректный ввод операции!");
        }
        if (op == '/' && b == 0) {
            System.out.println("На ноль делить нельзя!");
        }
        switch (op) {
            case '+' -> System.out.println(a + " + " + b + " = " + (a + b));
            case '-' -> System.out.println(a + " - " + b + " = " + (a - b));
            case '*' -> System.out.println(a + " * " + b + " = " + (a * b));
            case '/' -> System.out.println(a + " / " + b + " = " + (a / b));
            default -> System.out.println("Операция не может быть выполнена");
        }

    }

    public static int getDouble() {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextDouble()) {
            num = (int) scanner.nextDouble();
        } else {
            System.out.println("Ошибка при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getDouble();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:+,-,*,/");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
}


