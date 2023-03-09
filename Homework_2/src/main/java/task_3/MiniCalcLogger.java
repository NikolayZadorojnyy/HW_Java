/*
Реализовать простой калькулятор (+ - / *)
Ввод числа ->
Ввод знака ->
Ввод числа ->
К калькулятору добавить логирование.
*/
package task_3;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MiniCalcLogger {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(MiniCalcLogger.class.getName());
        FileHandler fh = new FileHandler("MiniCalc_log.txt", true);
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.info("Калькулятор запущен.");

        Scanner scaner = new Scanner(System.in);
        double a = getDouble(logger);
        double b = getDouble(logger);
        char op = getOperation(logger);
        scaner.close();
        if (!(op == '+' || op == '-' || op == '*' || op == '/')) {
            logger.warning("Некорректный ввод операции!");
            System.out.println("Некорректный ввод операции!");
        }
        if (op == '/' && b == 0) {
            logger.warning("На ноль делить нельзя!");
            System.out.println("На ноль делить нельзя!");
        }
        switch (op) {
            case '+' -> {
                System.out.println(a + " + " + b + " = " + (a + b));
                logger.info("Результат операции: " + (a + b));
            }
            case '-' -> {
                System.out.println(a + " - " + b + " = " + (a - b));
                logger.info("Результат операции: " + (a - b));
            }
            case '*' -> {
                System.out.println(a + " * " + b + " = " + (a * b));
                logger.info("Результат операции: " + (a * b));
            }
            case '/' -> {
                System.out.println(a + " / " + b + " = " + (a / b));
                logger.info("Результат операции: " + (a / b));
            }
            default -> System.out.println("Операция не может быть выполнена");
        }
        logger.info("----------Программа завершена!----------");
    }

    public static int getDouble(Logger log) {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextDouble()) {
            num = (int) scanner.nextDouble();
            log.info("Пользователь ввел число:" + num);
        } else {
            System.out.println("Ошибка при вводе числа. Попробуйте еще раз.");
            log.warning("Пользователь ввел некорректное число.");
            scanner.next();
            num = getDouble(log);
        }
        return num;
    }

    public static char getOperation(Logger log) {
        System.out.println("Введите операцию:+,-,*,/");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
            log.info("Пользователь ввел знак операции:" + operation);
        } else {
            System.out.println("Ошибка при вводе операции. Попробуйте еще раз.");
            log.warning("Пользователь ввел некорректный знак операции!");
            scanner.next();
            operation = getOperation(log);
        }
        return operation;
    }
}