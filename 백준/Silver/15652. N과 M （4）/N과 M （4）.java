import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static boolean[] visited;
    static int[] sequence;

    public static void dfs(int N, int M, int depth, int index) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = index; i <= N; i++) {
            sequence[depth] = i;
            dfs(N, M, depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        sequence = new int[M];

        dfs(N, M, 0, 1);

        System.out.println(sb);
    }
}