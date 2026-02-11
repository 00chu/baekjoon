import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] schedule = new int[N + 2][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N + 1; i++) {
            if (result < schedule[i][2]) {
                result = schedule[i][2];
            }

            int next = i + schedule[i][0];
            if (next <= N + 1) {
                schedule[next][2] = Math.max(schedule[next][2], result + schedule[i][1]);
            }
        }

        System.out.println(result);
    }
}