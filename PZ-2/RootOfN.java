public class RootOfN {

    private int n;

    public RootOfN(int n) {
        this.n = n;
    }

    // Метод для проверки, является ли число простым
    public boolean isPrime() {
        if (n <= 1) {
            return false; // 1 и меньшие числа не являются простыми
        }
        if (n <= 3) {
            return true; // 2 и 3 являются простыми числами
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false; // Если число делится на 2 или 3, то оно не простое
        }

        // Проверяем деление на числа вида 6k ± 1, где k - натуральное число
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false; // Если число делится на такие числа, то оно не простое
            }
        }

        return true; // Если не найдено делителей, то число простое
    }

    public static void main(String[] args) {
        int[] lst = {
                ((33 - 1) * (33 - 1)) + 1,
                (int) Math.pow(2, 1 + 1) - 1,
                (int) Math.pow(2, (int) (2 % 4)) + 1,
                20230926,
                20050212
        };

        for (int i : lst) {
            RootOfN algorithm = new RootOfN(i);
            boolean isPrime = algorithm.isPrime();
            if (isPrime) {
                System.out.println("Число простое");
            } else {
                System.out.println("Число составное");
            }
        }
    }
}
