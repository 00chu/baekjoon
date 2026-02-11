import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static boolean[] visited;
    static int[] sequence;
    static int[] temp;

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            temp[depth] = sequence[i];
            dfs(N, M, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        sequence = new int[N];
        temp = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sequence);

        sb = new StringBuilder();

        dfs(N, M, 0);

        System.out.println(sb);
    }
}