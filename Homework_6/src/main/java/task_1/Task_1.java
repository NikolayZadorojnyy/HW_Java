/*Подумать над структурой класса Ноутбук для магазина техники - выделить
поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации
и выведет ноутбуки, отвечающие фильтру.

NoteBook notebook1 = new NoteBook
NoteBook notebook2 = new NoteBook
NoteBook notebook3 = new NoteBook
NoteBook notebook4 = new NoteBook
NoteBook notebook5 = new NoteBook

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет

Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
Класс сделать в отдельном файле

приветствие
Выбор параметра
выбор конкретнее
вывод подходящих*/
package task_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {

        Notebook Huawei = new Notebook("Huawei", "8", "256", "Linux", "Black");
        Notebook Asus = new Notebook("Asus", "8", "256", "Windows 10", "White");
        Notebook Apple = new Notebook("Apple", "8", "256", "Mac OS", "Red");
        Notebook Honor = new Notebook("Honor", "16", "512", "Windows 11", "Grey");
        Notebook HP = new Notebook("HP", "4", "128", "Ubuntu", "Black");
        Notebook Huawei1 = new Notebook("Huawei", "32", "2000", "Windows 11", "white");
        Notebook MSI = new Notebook("MSI", "32", "2000", "Windows 11", "white");

        while (true) {

            ArrayList<Notebook> Notebooks = new ArrayList<>();
            Notebooks.add(Honor);
            Notebooks.add(Huawei);
            Notebooks.add(Apple);
            Notebooks.add(Asus);
            Notebooks.add(HP);
            Notebooks.add(Huawei1);
            Notebooks.add(MSI);

            boolean flag = false;
            int numPoisk = userInputInt("""
                    Параметры поиска:
                     1 - сортировка по марке,\s
                     2 - сортировка по оперативной памяти,\s
                     3 - сортировка по размеру SSD,\s
                     4 - сортировка по операционной системе,\s
                     5 - сортировка по цвету,\s
                     6 - показать весь список,\s
                     7 - завершить поиск\s""");

            if (numPoisk == 1 || numPoisk == 2 || numPoisk == 3 || numPoisk == 4 ||
                    numPoisk == 5 || numPoisk == 6 || numPoisk == 7) {
            } else {
                System.out.println("Введите правильные параметры поиска!");
            }

            if (numPoisk == 7) {
                break;
            }

            if (numPoisk == 6) {
                for (Notebook Notebook : Notebooks) {
                    Notebook.printInfo();
                    System.out.println();
                }

            } else if (numPoisk == 1) {
                String numParametr = userSInput("Напишите интресующий бренд");
                for (Notebook brand : Notebooks) {
                    if (brand.getBrand().equalsIgnoreCase(numParametr)) {
                        System.out.println(brand.printInfo());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Бренд не найден! Повторите поиск!");
                }

            } else if (numPoisk == 2) {
                String numParametr = userSInput("Напишите размер RAM: ");
                for (Notebook ram : Notebooks) {
                    if (ram.getRam().equalsIgnoreCase(numParametr)) {
                        System.out.println(ram.printInfo());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("RAM не найдена! Повторите поиск!");
                }

            } else if (numPoisk == 3) {
                String numParametr = userSInput("Напишите размер SSD: ");
                for (Notebook ssd : Notebooks) {
                    if (ssd.getSSD().equalsIgnoreCase(numParametr)) {
                        System.out.println(ssd.printInfo());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("SSD не найден! Повторите поиск!");
                }

            } else if (numPoisk == 4) {
                String numParametr = userSInput("Напишите интересующую операционную систему: ");
                for (Notebook os : Notebooks) {
                    if (os.getOs().equalsIgnoreCase(numParametr)) {
                        System.out.println(os.printInfo());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("ОС не найдена! Повторите поиск!");
                }

            } else if (numPoisk == 5) {
                String numParametr = userSInput("Напишите интересующий цвет: ");
                for (Notebook color : Notebooks) {
                    if (color.getColor().equalsIgnoreCase(numParametr)) {
                        System.out.println(color.printInfo());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Цвет не найден! Повторите поиск!");
                }

                return;
            }
        }
    }

    public static int userInputInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.println(msg);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return inputStr;
    }

    public static String userSInput(String msg) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        while (true) {
            System.out.println(msg);
            try {
                inputStr = sc.nextLine();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return inputStr;
    }
}


