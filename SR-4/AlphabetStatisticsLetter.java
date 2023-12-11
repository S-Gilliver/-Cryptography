import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class AlphabetStatisticsLetter {

    public static void main(String[] args) {
        // Имя файла, который мы будем анализировать
        String fileName = "SR-4/your_text_file.txt";

        try {
            // Читаем текст из файла
            String text = readTextFromFile(fileName);

            // Если текст успешно считан, выполняем анализ
            if (text != null) {
                // Вычисляем частоту каждой буквы в тексте
                Map<Character, Long> letterFrequency = calculateLetterFrequency(text);

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
        // Используем try-with-resources для автоматического закрытия BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Читаем файл построчно и объединяем строки в одну строку
            return br.lines().collect(Collectors.joining("\n"));
        }
    }

    // Метод для вычисления частоты каждой буквы в тексте
    private static Map<Character, Long> calculateLetterFrequency(String text) {
        // Приводим текст к нижнему регистру, чтобы не различать заглавные и строчные буквы
        text = text.toLowerCase();

        // Используем потоки для подсчета частоты букв
        return text.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    // Метод для вывода статистики в консоль
    private static void displayStatistics(Map<Character, Long> letterFrequency) {
        System.out.println("Статистика по буквам:");

        // Итерируемся по Map и выводим информацию о частоте и вероятности каждой буквы
        letterFrequency.forEach((letter, frequency) -> {
            double probability = (double) frequency / letterFrequency.size();

            // Выводим информацию о каждой букве
            System.out.println("'" + letter + "': Частота - " + frequency + ", Вероятность - " + probability);
        });
    }
}
