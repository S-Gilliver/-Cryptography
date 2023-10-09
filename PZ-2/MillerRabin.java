import java.util.Random;

public class MillerRabin {

    public static boolean isPrimeMillerRabin(int n, int k) {
        if (n <= 1) {
            return false;
        }

        if (n <= 3) {
            return true;
        }

        int r = 0;
        int d = n - 1;

        while (d % 2 == 0) {
            r++;
            d /= 2;
        }

        Random random = new Random();

        for (int i = 0; i < k; i++) {
            int a = 2 + random.nextInt(n - 3);
            int x = (int) Math.pow(a, d) % n;

            if (x == 1 || x == n - 1) {
                continue;
            }
            for (int j = 0; j < r - 1; j++) {
                x = (int) Math.pow(x, 2) % n;
                if (x == n - 1) {
                    break;
                }
            }
            if (x != n - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numberToCheck = 17;
        int k = 5;

        if (isPrimeMillerRabin(numberToCheck, k)) {
            System.out.println(numberToCheck + " - простое число");
        } else {
            System.out.println(numberToCheck + " - составное число");
        }
    }
}
