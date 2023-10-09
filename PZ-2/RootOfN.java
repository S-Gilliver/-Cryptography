public class RootOfN {

    private int n;

    public RootOfN(int n) {
        this.n = n;
    }

    public boolean isPrime() {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
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
