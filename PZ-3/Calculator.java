import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа:");
        int num1 = scanner.nextInt(); // Запрашиваем первое число от пользователя
        int num2 = scanner.nextInt(); // Запрашиваем второе число от пользователя

        while (true) {
            System.out.println("Введите операцию (1 - сложение) (2 - вычитание) (3 - умножение) (4 - деление) (0 - Выход)");
            String oper = scanner.next(); // Запрашиваем выбор операции от пользователя

            if (oper.equals("1")) { // Если выбрано сложение
                System.out.println("Результат: " + (new BigDecimal(num1)
                        .add(new BigDecimal(num2)))); // Выводим результат сложения
            } else if (oper.equals("2")) { // Если выбрано вычитание
                System.out.println("Результат: " + (new BigDecimal(num1)
                        .subtract(new BigDecimal(num2)))); // Выводим результат вычитания
            } else if (oper.equals("3")) { // Если выбрано умножение
                System.out.println("Результат: " + (new BigDecimal(num1)
                        .multiply(new BigDecimal(num2)))); // Выводим результат умножения
            } else if (oper.equals("4")) { // Если выбрано деление
                if (num2 != 0) { // Проверяем, что второе число не равно нулю
                    System.out.println("Результат: " + (new BigDecimal(num1)
                            .divide(new BigDecimal(num2)))); // Выводим результат деления
                } else {
                    System.out.println("Деление на ноль невозможно.");
                }
            } else if (oper.equals("0")) { // Если выбран выход из программы
                break; // Выходим из цикла
            } else {
                System.out.println("Такой операции не существует"); // Если введена некорректная операция
            }
        }
        scanner.close(); // Закрываем сканнер после завершения программы
    }
}
