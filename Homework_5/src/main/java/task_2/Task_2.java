/*
Пусть дан список сотрудников:

"Иван Иванов","Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
"Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
"Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
"Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени.
*/
package task_2;


import java.util.*;

public class Task_2 {
    public static void main(String[] args) {

        List<String> startList = List.of("Иван Иванов","Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");

        System.out.println("Стартовый лист: ");
        printLst(startList);
        List<String> changedList = new ArrayList<>();
        for (String s : startList) {
            changedList.add(s.split(" ")[0]); // отбрасываем фамилии
        }
        HashMap<String, Integer> names = new HashMap<>();
        for (String value : changedList) {
            names.merge(value, 1, Integer::sum); // считаем количество вхождений каждого имени
        }
        System.out.println("Сортированный лист по убыванию вхождений имен: ");
        names.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

       public static void printLst(List<String> list) {
        for (var name: list) {
            System.out.println(name);
        }
    }
}
