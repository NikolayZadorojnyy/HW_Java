/*
Пусть дан произвольный список целых чисел, удалить из него чётные числа
*/
package task_2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task_2 {

    public static void main(String[] args) {
        List<Integer> my_list = getRandomList(10);

        for (int i = 0; i < my_list.size(); i++) {
            if (my_list.get(i) % 2 == 0) {
                my_list.remove(my_list.get(i));
                i--;
            }
        }

        System.out.println(my_list);
    }

    public static List<Integer> getRandomList(int size) {

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(100));
        }

        System.out.println(randomList);
        return randomList;
    }
}



