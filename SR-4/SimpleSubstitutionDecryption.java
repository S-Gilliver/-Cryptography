import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleSubstitutionDecryption {

    public static void main(String[] args) {
        try {
            String encryptedText = readFromFile("SR-4/encrypted_text.txt");
            String decryptedText = decrypt(encryptedText);
            System.out.println("Decrypted Text:\n" + decryptedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private static String decrypt(String encryptedText) {
        Map<Character, Character> decryptionMap = createDecryptionMap();

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

    private static Map<Character, Character> createDecryptionMap() {
        // Пример шифра, замените его на свой
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String cipher = "bcdefghijklmnopqrstuvwxyza"; // пример шифра: сдвиг на 1 букву вправо

        Map<Character, Character> decryptionMap = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            decryptionMap.put(cipher.charAt(i), alphabet.charAt(i));
        }
        return decryptionMap;
    }
}
