import java.util.Random;

public class MillerRabin {

    // Метод для проверки простоты числа n с использованием теста Миллера-Рабина
    public static boolean isPrimeMillerRabin(int n, int k) {
        // Если n меньше или равно 1, то оно не является простым числом
        if (n <= 1) {
            return false;
        }

        // Если n меньше или равно 3, то оно является простым числом
        if (n <= 3) {
            return true;
        }

        // Находим числа r и d такие, что n - 1 = 2^r * d
        int r = 0;
        int d = n - 1;

        while (d % 2 == 0) {
            r++;
            d /= 2;
        }

        Random random = new Random();

        // Выполняем тест Миллера-Рабина k раз
        for (int i = 0; i < k; i++) {
            // Генерируем случайное a в диапазоне [2, n - 2]
            int a = 2 + random.nextInt(n - 3);
            // Вычисляем x = a^d mod n
            int x = (int) Math.pow(a, d) % n;

            // Если x равно 1 или n - 1, продолжаем следующую итерацию
            if (x == 1 || x == n - 1) {
                continue;
            }

            // Возводим x в квадрат r - 1 раз и проверяем, не станет ли он равным n - 1
            for (int j = 0; j < r - 1; j++) {
                x = (int) Math.pow(x, 2) % n;
                if (x == n - 1) {
                    break;
                }
            }

            // Если x не становится равным n - 1, то число n не является простым
            if (x != n - 1) {
                return false;
            }
        }

        // Если после k итераций число n прошло тест, оно вероятно простое
        return true;
    }

    public static void main(String[] args) {
        int numberToCheck = 17;
        int k = 5;

        // Проверяем, является ли число numberToCheck простым с использованием теста Миллера-Рабина
        if (isPrimeMillerRabin(numberToCheck, k)) {
            System.out.println(numberToCheck + " - простое число");
        } else {
            System.out.println(numberToCheck + " - составное число");
        }
    }
}
