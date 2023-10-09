import java.util.Scanner;

public class Sieve {
    // Функция для решета Эратосфена, возвращает массив булевых значений, где каждый индекс представляет число, а значение указывает,
    // является ли это число простым (true) или составным (false).
    public static boolean[] sieveEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];

        // Инициализируем массив как все числа простыми
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        // 0 и 1 не являются простыми числами
        isPrime[0] = isPrime[1] = false;

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                // Помечаем все кратные p как составные числа
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }

        return isPrime;
    }

    // Функция для проверки, является ли число простым, используя решето Эратосфена
    public static boolean isPrimeUsingSieve(int n) {
        boolean[] primes = sieveEratosthenes(n);
        return primes[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для проверки: ");
        int numberToCheck = scanner.nextInt();
        scanner.close();

        if (isPrimeUsingSieve(numberToCheck)) {
            System.out.println(numberToCheck + " - простое число");
        } else {
            System.out.println(numberToCheck + " - составное число");
        }
    }
}
