/*
В калькулятор добавьте возможность отменить последнюю операцию.
Пример 1 + 2 ответ: 3 + 4 ответ: 7 Отмена 3 * 3 ответ: 9
Дополнительно каскадная отмена - отмена нескольких операций
*/
package task_3;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class Task_3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Double> st = new Stack<>();
        double result = 0;
        DecimalFormat dF = new DecimalFormat("##.###");
        Scanner scaner = new Scanner(System.in);
        double a = getDouble();
        st.push(a);
        while (true) {
            char op = getOperation();
            double b = getDouble();
            st.push(b);

            if (op == '/' && b == 0) {
                System.out.println("На ноль делить нельзя!");
            }
            switch (op) {
                case '+' -> {
                    b = st.pop();
                    a = st.pop();
                    result = a + b;
                    System.out.println(dF.format(a) + " + " + b + " = " + dF.format(a + b));
                    st.push(a);
                }
                case '-' -> {
                    b = st.pop();
                    a = st.pop();
                    result = a - b;
                    System.out.println(dF.format(a) + " - " + b + " = " + dF.format(a - b));
                    st.push(a);
                }
                case '*' -> {
                    b = st.pop();
                    a = st.pop();
                    result = a * b;
                    System.out.println(dF.format(a) + " * " + b + " = " + dF.format(a * b));
                    st.push(a);
                }
                case '/' -> {
                    b = st.pop();
                    a = st.pop();
                    result = a / b;
                    System.out.println(dF.format(a) + " / " + b + " = " + dF.format(a / b));
                    st.push(a);
                }
                default -> System.out.println("Операция не может быть выполнена");
            }
            System.out.println(
                    "Для отмены операции - 'yes'\nДля породолжения - 'no'\nДля выхода - 'exit'");

            String choice = scaner.next();
            if (choice.equals("yes")) {
                System.out.println(dF.format(st.peek()));
            }else if (choice.equals("no")) {
                System.out.println(dF.format(result));
                st.push(result);
            }else  if (choice.equals("exit")) {
                break;
            }else {
                System.out.println("Решение пользователя не определено!");
                break;
            }
        }
         scaner.close();
        System.out.println("Программа завершена!");
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
        scanner.hasNext();
        operation = scanner.next().charAt(0);
        if (!(operation == '+' || operation == '-' || operation == '*' || operation == '/')) {
            System.out.println("Ошибка при вводе операции. Попробуйте еще раз.");
            operation = getOperation();
        }
        return operation;
    }
}

