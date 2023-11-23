import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AlphabetStatistics {

    public static void main(String[] args) {
        // Имя файла, который мы будем анализировать
        String fileName = "SR-4/your_text_file.txt";

        try {
            // Читаем текст из файла
            String text = readTextFromFile(fileName);

            // Если текст успешно считан, выполняем анализ
            if (text != null) {
                // Вычисляем частоту каждой буквы в тексте
                Map<Character, Integer> letterFrequency = calculateLetterFrequency(text);

                // Выводим статистику в консоль
                displayStatistics(letterFrequency);
            }
        } catch (IOException e) {
            // В случае ошибки ввода/вывода выводим сообщение об ошибке
            e.printStackTrace();
        }
    }

    // Метод для чтения текста из файла
    private static String readTextFromFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        // Используем try-with-resources для автоматического закрытия BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Читаем файл построчно и добавляем каждую строку в StringBuilder
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }

        // Возвращаем строку, содержащую текст из файла
        return stringBuilder.toString();
    }

    // Метод для вычисления частоты каждой буквы в тексте
    private static Map<Character, Integer> calculateLetterFrequency(String text) {
        // Создаем TreeMap для хранения частоты букв в отсортированном порядке
        Map<Character, Integer> letterFrequency =
                new TreeMap<>(Comparator.comparingInt((Character o) ->
                        Character.toLowerCase(o)).thenComparingInt(o -> o));

        // Приводим текст к нижнему регистру, чтобы не различать заглавные и строчные буквы
        text = text.toLowerCase();

        // Итерируемся по каждому символу в тексте
        for (char c : text.toCharArray()) {
            // Если символ является буквой, увеличиваем его частоту в Map
            if (Character.isLetter(c)) {
                letterFrequency.put(c, letterFrequency.getOrDefault(c, 0) + 1);
            }
        }

        // Возвращаем Map с частотой каждой буквы
        return letterFrequency;
    }

    // Метод для вывода статистики в консоль
    private static void displayStatistics(Map<Character, Integer> letterFrequency) {
        System.out.println("Статистика по буквам:");

        // Итерируемся по Map и выводим информацию о частоте и вероятности каждой буквы
        for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            char letter = entry.getKey();
            int frequency = entry.getValue();
            double probability = (double) frequency / letterFrequency.size();

            // Выводим информацию о каждой букве
            System.out.println("'" + letter + "': Частота - " + frequency + ", Вероятность - " + probability);
        }
    }
}
