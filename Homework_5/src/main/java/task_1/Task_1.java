/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь
несколько телефонов. Добавить функции  1) Добавление номера 2) Вывод всего
Пример: Я ввожу: 1
        К: Введите фамилию
        Я: Иванов
        К: Введите номер
        Я: 1242353
        К: Введите 1) Добавление номера
        2) Вывод всего
        Я ввожу: 1
        К: Введите фамилию
        Я: Иванов
        К: Введите номер
        Я: 547568
        К: Введите 1) Добавление номера
        2) Вывод всего
        Я ввожу: 2
        Иванов: 1242353, 547568
*/
package task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, ArrayList<Long>> bookPhone = new HashMap<>();

        while (true) {
            System.out.println(
                    "Управление телефонной книгой:\n" +
                            " '1'- добавить телефон\n" +
                            " '2'- показать данные\n" +
                            " '3'- выход");

            var choice = scanner.next().charAt(0);
            if (choice != '3' && choice != '2' && choice != '1') {
                System.out.println("Вы ввели некорректные данные");
            }
            if (choice == '3') {
                System.out.println("Программа завершена!");
                break;
            }
            if (choice == '2') {
                if (bookPhone.isEmpty()) {
                    System.out.println("Телефонная книга пуста!");
                }
                printPhoneBook(bookPhone);
            }
            if (choice == '1') {
                addNumber(bookPhone);
            }
        }
        scanner.close();
    }

    public static void addNumber(Map<String, ArrayList<Long>> map) {

        System.out.print("Введите фамилию: ");
        String name = scanner.next();
        System.out.print("Введите номер телефона: ");
        String Num = scanner.next();
        Long num;
        try {
            num = Long.parseLong(Num);
            if (map.containsKey(name)) {
                map.get(name).add(num);  // если контакт есть, добавляем номер
                System.out.println("Контакту " + name + " добавлен еще один номер " + num);
            } else {
                ArrayList<Long> list = new ArrayList<>();
                list.add(num);   // если контакт нет, добавляем имя и номер
                map.put(name, list);
                System.out.println("Новый контакт " + name + " успешно создан.");
            }
        } catch (NumberFormatException ex) {
            System.out.print("Некорректный ввод " + Num + " не является числом!\n");
            addNumber(map);
        }
    }

    public static void printPhoneBook(Map<String, ArrayList<Long>> map) {
        for (var number : map.entrySet()) {
            System.out.printf("%s - %s\n",
                    number.getKey(), number.getValue().toString().replace("[", "").replace("]", ""));
        }
    }
}
