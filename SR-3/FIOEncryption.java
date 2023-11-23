import java.util.Scanner;

public class FIOEncryption {
    // Создаем строку с русским алфавитом, включая заглавные и строчные буквы.
    static String alfavit_RU = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯАБВГДЕЁЖЗИйКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    static String itog = ""; // Переменная для хранения результата шифрования или дешифрования.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберете действие:");
        System.out.println("1 - шифрование");
        System.out.println("2 - дешифрование");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Избавляемся от символа новой строки во входных данных.

        if (choice == 1) {
            System.out.print("Введите сообщение: ");
            String message = scanner.nextLine().toUpperCase(); // Ввод и преобразование в верхний регистр.
            System.out.print("Шаг шифровки: ");
            int step = scanner.nextInt();
            encrypt(message, step); // Вызываем функцию шифрования.
        } else if (choice == 2) {
            System.out.print("Введите сообщение: ");
            String message = scanner.nextLine().toUpperCase(); // Ввод и преобразование в верхний регистр.
            System.out.print("Шаг дешифровки: ");
            int step = scanner.nextInt();
            decrypt(message, step); // Вызываем функцию дешифрования.
        }

        System.out.println(itog); // Выводим результат.
    }

    static void encrypt(String message, int step) {
        for (char c : message.toCharArray()) {
            int place = alfavit_RU.indexOf(c); // Находим индекс символа в алфавите.
            int newPlace = (place + step) % alfavit_RU.length(); // Вычисляем новый индекс с учетом шага.
            if (alfavit_RU.contains(String.valueOf(c))) {
                itog += alfavit_RU.charAt(newPlace); // Добавляем зашифрованный символ к результату.
            } else {
                itog += c; // Если символ не найден в алфавите, оставляем его без изменений.
            }
        }
    }

    static void decrypt(String message, int step) {
        for (char c : message.toCharArray()) {
            int place = alfavit_RU.indexOf(c); // Находим индекс символа в алфавите.
            int newPlace = (place - step + alfavit_RU.length()) % alfavit_RU.length(); // Вычисляем новый индекс с учетом шага.
            if (alfavit_RU.contains(String.valueOf(c))) {
                itog += alfavit_RU.charAt(newPlace); // Добавляем расшифрованный символ к результату.
            } else {
                itog += c; // Если символ не найден в алфавите, оставляем его без изменений.
            }
        }
    }
}
