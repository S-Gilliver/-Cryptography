import java.util.Scanner;

public class NOD {
    public static void main(String[] args) {
        int a, b;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Вставьте числа a и b (пример: \"24 2\"): ");
        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.print(a + " and " + b + " = ");

        if (a != b) {
            while (a != 0 && b != 0) {
                if (a > b) {
                    a %= b;
                } else {
                    b %= a;
                }
            }
            System.out.println(a + b);
        } else {
            System.out.println(a);
        }
    }
}
