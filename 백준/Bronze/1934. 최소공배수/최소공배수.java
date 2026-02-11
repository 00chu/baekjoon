import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) { //유클리드호제법
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a, b, result;

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            result = a * b / gcd(a, b);
            System.out.println(result);
        }
    }
}