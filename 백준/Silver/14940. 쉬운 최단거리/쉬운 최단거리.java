import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] map;
    static int[][] result;

    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] row = {-1, 0, 1, 0};
    static int[] column = {0, -1, 0, 1};

    public static void bfs(Coordinate coordinate, int N, int M) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coordinate);

        result[coordinate.r][coordinate.c] = 0;

        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = temp.r + row[i];
                int c = temp.c + column[i];

                if (0 > r || r >= N || 0 > c || c >= M || result[r][c] != -1) {
                    continue;
                }

                result[r][c] = result[temp.r][temp.c] + 1;
                queue.add(new Coordinate(r, c));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];

        Coordinate start = new Coordinate(0, 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    result[i][j] = -1;
                } else if (map[i][j] == 2) {
                    start = new Coordinate(i, j);
                }
            }
        }

        bfs(start, N, M);
        
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}