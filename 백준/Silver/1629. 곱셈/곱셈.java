import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long compute(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long temp = compute(A, B / 2, C);

        if (B % 2 == 1) {
            return temp * temp % C * A % C;
        }

        return temp * temp % C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(compute(A, B, C));
    }
}