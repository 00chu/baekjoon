import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (Math.pow(i, 2) <= N) {
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}