import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 1;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) result = ((result * 2) + 1) % 10007;
            else  result = ((result * 2) - 1) % 10007;
        }

        System.out.println(result);
    }
}