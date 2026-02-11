import java.util.Scanner;

public class Main {
    public static long gcd(long a, long b) { //유클리드호제법
        while (b != 0) {
            long r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a, b, result;

        a = sc.nextInt();
        b = sc.nextInt();

        result = a * b / gcd(a, b);
        System.out.println(result);

    }
}