import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleSubstitutionDecryption {

    public static void main(String[] args) {
        try {
            // Чтение зашифрованного текста из файла
            String encryptedText = readFromFile("SR-4/encrypted_text.txt");

            // Расшифровка текста и вывод результата
            String decryptedText = decrypt(encryptedText);
            System.out.println("Decrypted Text:\n" + decryptedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения текста из файла
    private static String readFromFile(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    // Метод для расшифровки текста с использованием простой подстановки
    private static String decrypt(String encryptedText) {
        // Создание карты для расшифровки с использованием простой подстановки
        Map<Character, Character> decryptionMap = createDecryptionMap();

        // Расшифровка текста
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                char decryptedChar = decryptionMap.getOrDefault(Character.toLowerCase(c), c);
                decryptedText.append(Character.isUpperCase(c) ? Character.toUpperCase(decryptedChar) : decryptedChar);
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }

    // Метод для создания карты подстановки на основе примера шифра
    private static Map<Character, Character> createDecryptionMap() {
        // Пример шифра, замените его на свой
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String cipher = "ьэюяабвгдеёжзийклмнопрстуфхцчшщъы"; // пример шифра: сдвиг на 1 букву вправо

        // Создание карты подстановки
        Map<Character, Character> decryptionMap = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            decryptionMap.put(cipher.charAt(i), alphabet.charAt(i));
        }
        return decryptionMap;
    }
}
