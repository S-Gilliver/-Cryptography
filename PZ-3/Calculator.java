import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        while (true) {
            System.out.println("Введите операцию (1 - сложение) (2 - вычитание) (3 - умножение) (4 - деление) (0 - Выход)");
            String oper = scanner.next();

            if (oper.equals("1")) {
                System.out.println("Результат: " + (new BigDecimal(num1)
                        .add(new BigDecimal(num2))));
            } else if (oper.equals("2")) {
                System.out.println("Результат: " + (new BigDecimal(num1)
                        .subtract(new BigDecimal(num2))));
            } else if (oper.equals("3")) {
                    System.out.println("Результат: " + (new BigDecimal(num1)
                            .multiply(new BigDecimal(num2))));
            } else if (oper.equals("4")) {
                if (num2 != 0) {
                    System.out.println("Результат: " + (new BigDecimal(num1)
                            .divide(new BigDecimal(num2))));
                } else {
                    System.out.println("Деление на ноль невозможно.");
                }
            } else if (oper.equals("0")) {
                break;
            } else {
                System.out.println("Такой операции не существует");
            }
        }
        scanner.close();
    }
}
