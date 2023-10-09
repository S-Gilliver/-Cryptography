import java.util.Random;
import java.util.Scanner;

public class Ferma {
    public static boolean isPrime(int n, int k) {
        if (n <= 1 || n % 2 == 0) {
            return n == 2;
        }

        // Проводим тест Ферма k раз
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int a = random.nextInt(n - 3) + 2;
            if (powerMod(a, n - 1, n) != 1) {
                return false;
            }
        }

        return true;
    }

    public static int powerMod(int base, int exponent, int modulus) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для проверки: ");
        int numberToCheck = scanner.nextInt();
        int k = 5; // Количество итераций теста Ферма
        if (isPrime(numberToCheck, k)) {
            System.out.println(numberToCheck + " - простое число");
        } else {
            System.out.println(numberToCheck + " - составное число");
        }
    }
}
