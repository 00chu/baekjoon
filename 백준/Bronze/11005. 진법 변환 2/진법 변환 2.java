import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = N % B;

            if (10 <= num) {
                sb.append((char) (num + 55));
            } else {
                sb.append(num);
            }

            if (N >= B) {
                N = N / B;
            } else {
                break;
            }
        }

        System.out.println(sb.reverse());
    }
}