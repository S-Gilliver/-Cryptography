import java.util.Scanner;

public class CaesarCipher {
    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                // Определение базовой буквы (заглавной или строчной) для шифрования
                char base = (Character.isLowerCase(c)) ? 'а' : 'А';
                // Шифрование символа с использованием ключа и периодичности 32 символа
                encrypted.append((char) ((c - base + key) % 32 + base));
            } else {
                // Если символ не является буквой, добавляем его без изменений
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String input, int key) {
        // Дешифрование просто вызывает функцию шифрования с инвертированным ключом
        return encrypt(input, 32 - (key % 32));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        String fio = scanner.nextLine();
        System.out.println("Введите ключ от 1 до 32 включительно: ");
        int key = scanner.nextInt();

        if (key < 1 || key > 32) {
            System.out.println("Введен неправильный ключ");
            return;
        }

        System.out.println("Введите операцию (1 - шифрование) (2 - расшифрование)");
        String oper = scanner.next(); // Запрашиваем выбор операции от пользователя

        if (oper.equals("1")) {
            String encryptedFIO = encrypt(fio, key);
            System.out.println("Зашифрованное ФИО: " + encryptedFIO);
        } else if (oper.equals("2")) {
            String decryptedFIO = decrypt(fio, key);
            System.out.println("Расшифрованное ФИО: " + decryptedFIO);
        } else {
            System.out.println("Введена неправильная операция");
        }

        scanner.close();
    }
}
