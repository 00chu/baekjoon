import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[][] score;

    static int result;

    static void combination(int s, int count) {
        if (count == N / 2) {
            sum();
            return;
        }

        for (int i = s; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    static void sum() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += score[i][j];
                    start += score[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += score[i][j];
                    link += score[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(start - link));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        score = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        combination(0, 0);

        System.out.println(result);
    }
}