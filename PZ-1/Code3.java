public class Code3 {
    public static void main(String[] args) {
        int n = 27;
        int a = (n + 1) * (n + 2);
        int b = (n + 2) * (n + 3);
        //возводим число в степень
        int c = (int) Math.pow(n + 2, 3);

        int[] result = extendedEuclidean(a, b);

        if (c % result[0] == 0) {
            int x = result[1] * (c / result[0]);
            int y = result[2] * (c / result[0]);
            System.out.println("Решение для a*x + b*y = c:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            System.out.println("Для данного значения n решения не существует.");
            // Решение Диофантова уравнения 8x + 16y = 64:
            int[] result2 = extendedEuclidean(8, 16);
            int x2 = result2[1] * 64;
            int y2 = result2[2] * 64;
            System.out.println("Решение для 8x + 16y = 64:");
            System.out.println("x = " + x2);
            System.out.println("y = " + y2);
        }
    }

    // Расширенный алгоритм Евклида
    public static int[] extendedEuclidean(int a, int b) {
        if (b == 0) {
            return new int[] { a, 1, 0 };
        } else {
            int[] vals = extendedEuclidean(b, a % b);
            int d = vals[0];
            int x = vals[2];
            int y = vals[1] - (a / b) * vals[2];
            return new int[] { d, x, y };
        }
    }
}
