import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb;

    public static void dfs(int k, int depth, int index) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = list[i];
                dfs(k, depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            list = new int[k];
            result = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list);

            dfs(k, 0, 0);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}