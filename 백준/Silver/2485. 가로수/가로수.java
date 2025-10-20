import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int gcd(int a, int b) { //유클리드호제법
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];

        int num = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
            if (0 < i) {
                num = gcd(tree[i] - tree[i - 1], num);
            }
        }

        System.out.println((tree[N - 1] - tree[0]) / num - N + 1);
    }
}