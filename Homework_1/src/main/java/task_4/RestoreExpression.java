/*
Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет.
Ввод: 2? + ?5 = 69
Вывод: 24 + 45 = 69
*/
package task_4;

import java.util.HashSet;
import java.util.Scanner;

public class RestoreExpression {
    public static HashSet<String> combinationsSet = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Введите выражение типа ?? + ?? = ?? (вместо ? можно ставить цифры 1-9)");
        String expression = new Scanner(System.in).nextLine();
        expression = expression.replace(" ", ""); //убираем пробелы из введенной строки

        int countChar = (int) expression.chars().filter(ch -> ch == '?').count(); // получаем кол. ? для замены


        combinations("", "0123456789", countChar); // формируем список всех вариантов замен
        for (String s : combinationsSet) {
            calculate(expression, s);
        }
    }

    // функция combinations генерирует возможные комбинации замен
    public static void combinations(String prefix, String strFull, int lengthArray) {
        if (prefix.length() > lengthArray) {
            return;
        }
        if (prefix.length() == lengthArray) {
            combinationsSet.add(prefix);
        }
        for (char symbol : strFull.toCharArray()) {
            combinations(prefix + symbol, strFull, lengthArray);
        }
    }

    // функция вычисления вариантов
    private static void calculate(String exprStr, String combStr) {
        int index = 0;
        for (int i = 0; i < exprStr.length(); i++) {
            if (exprStr.charAt(i) == '?') {
                // собираем строку после замены ?
                exprStr = exprStr.substring(0, i) + combStr.charAt(index) + exprStr.substring(i + 1);
                index++;
            }
        }
        String answerString = exprStr.substring(exprStr.indexOf("=") + 1); // вытаскиваем из строки все что после равно
        String number1String = exprStr.substring(0, exprStr.indexOf("+")); // вытаскиваем первое слагаемое
        String number2String = exprStr.substring(exprStr.indexOf("+") + 1, exprStr.indexOf("=")); // второе слагаемое
        int res = Integer.parseInt(number1String) + Integer.parseInt(number2String); // парсим из строк в int и складываем
        int answer = Integer.parseInt(answerString); // парсим и проверяем результат
        if (res == answer) {
            System.out.println(exprStr); // печать вариантов решения
        }
    }
}