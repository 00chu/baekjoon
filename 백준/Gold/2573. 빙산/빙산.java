import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static boolean[][] visited;

  public static void countIceberg(int N, int M, int r, int c) {
    if (!visited[r][c] && graph[r][c] != 0) {
      visited[r][c] = true;

      if (1 < r) {
        countIceberg(N, M, r - 1, c);
      }
      if (r < N - 1) {
        countIceberg(N, M, r + 1, c);
      }
      if (1 < c) {
        countIceberg(N, M, r, c - 1);
      }
      if (c < M - 1) {
        countIceberg(N, M, r, c + 1);
      }
    }
  }

  public static void melt(int N, int M, int r, int c) {
    if (c >= M - 1) {
      c = 1;
      r++;
    }

    if (graph[r][c] > 0) {
      if (graph[r - 1][c] == 0 && !visited[r - 1][c]) {
        graph[r][c]--;
      }
      if (graph[r][c - 1] == 0 && !visited[r][c - 1]) {
        graph[r][c]--;
      }
      if (graph[r + 1][c] == 0 && !visited[r + 1][c]) {
        graph[r][c]--;
      }
      if (graph[r][c + 1] == 0 && !visited[r][c + 1]) {
        graph[r][c]--;
      }

      if (graph[r][c] <= 0) {
        graph[r][c] = 0;
        visited[r][c] = true;
      }
    }

    if (r < N - 1) {
      melt(N, M, r, c + 1);
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;

    while (true) {
      visited = new boolean[N][M];
      melt(N, M, 1, 1);

      visited = new boolean[N][M];
      int count = 0;
      boolean flag = true;

      for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
          if (!visited[i][j] && graph[i][j] != 0) {
            flag = false;
            count++;
            countIceberg(N, M, i, j);
          }
        }
      }

      if (flag) {
        System.out.println(0);
        return;
      }

      result++;

      if (count >= 2) {
        break;
      }
    }

    System.out.println(result);
  }
}