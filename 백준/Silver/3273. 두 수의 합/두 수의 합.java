import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(list);

        for (int i = 0; i < N - 1; i++) {
            int j;
            for (j = N - 1 - count; j > i; j--) {

                if (list[i] + list[j] == M) {
                    count++;
                    break;
                }
            }
            if (list[i] + list[j] > M) {
                break;
            }
        }

        System.out.println(count);

    }
}