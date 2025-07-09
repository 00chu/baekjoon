import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] weight;
    static int[] durability;
    static int result = 0;

    public static void dfs(int N, int index) {
        if (index == N) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (durability[i] <= 0) {
                    temp++;
                }
            }
            result = Math.max(result, temp);
            return;
        }

        if (durability[index] > 0) {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (i != index && durability[i] > 0) {
                    flag = true;
                    durability[index] -= weight[i];
                    durability[i] -= weight[index];
                    dfs(N, index + 1);
                    durability[index] += weight[i];
                    durability[i] += weight[index];
                }
            }
            if (!flag) {
                dfs(N, index + 1);
            }
        } else {
            dfs(N, index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        durability = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(N, 0);

        System.out.println(result);
    }
}