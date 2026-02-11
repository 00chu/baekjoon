import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] operation;
    static int[] list;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int sum = 0;

    public static void dfs(int N, int depth) {
        if (depth == N - 1) {
            sum = num[0];
            for (int i = 0; i < N - 1; i++) {
                if (list[i] == 0) {
                    sum += num[i + 1];
                } else if (list[i] == 1) {
                    sum -= num[i + 1];
                } else if (list[i] == 2) {
                    sum *= num[i + 1];
                } else {
                    if (sum < 0) {
                        sum = -sum / num[i + 1];
                        sum = -sum;
                    } else {
                        sum /= num[i + 1];
                    }
                }
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] != 0) {
                operation[i]--;

                list[depth] = i;

                dfs(N, depth + 1);

                operation[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        list = new int[N - 1];

        dfs(N, 0);

        System.out.println(max);
        System.out.println(min);
    }
}