/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
*/
package task_2;

import java.util.LinkedList;
import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        LinkedList<Integer> list_start = new LinkedList<>();
        int add_number = 100;
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            list_start.add(i, rand.nextInt(10));
        }
        System.out.printf("Начальный список: %s \n", list_start);
        System.out.println("Добавим эл. | " +add_number
                + " | Список плюс элемент в конец: "+ enqueue(list_start, add_number));
        System.out.println("Первый эл. | " + dequeue(list_start)
                + " | Список минус первый элемент: "+ list_start);
        System.out.println("Первый эл. | "+first(list_start)
                +" | Список без удаления первого элемента: " + list_start);
    }

    //        enqueue() - добавляет элемент в конец очереди,
    public static LinkedList<Integer> enqueue(LinkedList<Integer> list, int num) {
        list.addLast(num);
        return list;
    }

    //        dequeue() - возвращает первый элемент из очереди и удаляет его.
    public static int dequeue(LinkedList<Integer> list) {
        int num = list.getFirst();
        list.removeFirst();
        return num;
    }

    //        first() - возвращает первый элемент из очереди, не удаляя его.
    public static int first(LinkedList<Integer> list) {
        return list.getFirst();
    }

}