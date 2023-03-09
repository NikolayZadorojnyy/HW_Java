/*
Дана строка (получение через обычный текстовый файл!!!)
"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"
Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/
package task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParsingTxtFile {
    public static void main(String[] args) {
        // читаем файл
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("task2.txt"))) {
            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data).append(";"); // добавляем будущий разделитель строки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // создание словаря
        Map<String, String> map = new HashMap<>();

        //Парсим строку, убираем лишние символы и записываем данные в словарь
        String[] keys = sb.toString().replace("\"", "").  // убираем ковычки
                replaceAll("\\s", "").  // убираем все пробелы
                split(";");  // делим строку по ;

        for (String data : keys) {
            String[] person = data.split(",");
            for (String keyValues : person) {
                String[] keyValue = keyValues.split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                map.put(key, value);
            }
            System.out.printf("Студент %s получил %s по предмету %s.\n", map.get("фамилия"),
                    map.get("оценка"), map.get("предмет"));
        }
    }
}