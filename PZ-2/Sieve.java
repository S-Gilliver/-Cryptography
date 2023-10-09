import java.util.Scanner;

public class Sieve {
    public static boolean[] sieveEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }

        return isPrime;
    }

    public static boolean isPrimeUsingSieve(int n) {
        boolean[] primes = sieveEratosthenes(n);
        return primes[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int numberToCheck = scanner.nextInt();
        scanner.close();

        if (isPrimeUsingSieve(numberToCheck)) {
            System.out.println(numberToCheck + " - простое число");
        } else {
            System.out.println(numberToCheck + " - составное число");
        }
    }
}
