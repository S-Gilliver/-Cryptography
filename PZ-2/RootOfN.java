public class RootOfN {

    private int n;

    public RootOfN(int n) {
        this.n = n;
    }

    public boolean isPrime() {
        int sqrtN = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] lst = {
                ((33 - 1) * (33 - 1)) + 1,
                (int) Math.pow(2, 1 + 1) - 1,
                (int) Math.pow(2, 2 % 4) + 1,
                20230926,
                20050212
        };

        for (int i : lst) {
            RootOfN algorithm = new RootOfN(i);
            boolean flag = algorithm.isPrime();
            if (flag) {
                System.out.println("Число простое");
            } else {
                System.out.println("Число составное");
            }
        }
    }
}
