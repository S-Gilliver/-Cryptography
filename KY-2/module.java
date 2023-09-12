import java.util.Scanner;

public class module {
    public static int mod(int a, int b) {
        int p = a / b;
        int mod = a - b * p;
        return mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа для вычисления остатка:");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("Встроенный оператор %: " + a + " % " + b + " = " + (a % b));
        System.out.println("Самописная функция mod: " + a + " % " + b + " = " + mod(a, b));
    }
}