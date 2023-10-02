import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите коэффициент a: ");
        int a = scanner.nextInt();
        System.out.print("Введите коэффициент b: ");
        int b = scanner.nextInt();
        System.out.print("Введите коэффициент c: ");
        int c = scanner.nextInt();

        int gcd = findGCD(a, b);

        if (c % gcd == 0) {
            ExtendedGCDResult result = extendedGCD(a, b);
            int x0 = result.x * (c / gcd);
            int y0 = result.y * (c / gcd);

            System.out.println("Частные корни: ");
            System.out.println("x = " + x0);
            System.out.println("y = " + y0);
        } else {
            System.out.println("Уравнение не имеет целых корней.");
        }
    }

    // Нахождение НОД двух чисел
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }

    // Расширенный алгоритм Евклида для нахождения x и y таких, что ax + by = НОД(a, b)
    public static ExtendedGCDResult extendedGCD(int a, int b) {
        if (b == 0) {
            return new ExtendedGCDResult(a, 1, 0);
        } else {
            ExtendedGCDResult result = extendedGCD(b, a % b);
            int x = result.y;
            int y = result.x - (a / b) * result.y;
            return new ExtendedGCDResult(result.gcd, x, y);
        }
    }

    // Класс для хранения результатов расширенного алгоритма Евклида
    public static class ExtendedGCDResult {
        public int gcd;
        public int x;
        public int y;

        public ExtendedGCDResult(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }
}
