import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isPossible(int I, int r, int c) {
        return 0 <= r && r < I && 0 <= c && c < I;
    }

    public static void bfs(int I, int r1, int c1, int r2, int c2) {
        board = new int[I][I];
        visited = new boolean[I][I];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(r1, c1));

        board[r1][c1] = 1;
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();

            if (board[r2][c2] != 0) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int r = temp.r + y[i];
                int c = temp.c + x[i];

                if (isPossible(I, r, c) && board[r][c] == 0) {
                    board[r][c] = board[temp.r][temp.c] + 1;
                    queue.offer(new Coordinate(r, c));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            bfs(I, r1, c1, r2, c2);

            sb.append(board[r2][c2] - 1);
            if (i != N - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}