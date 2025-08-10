import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static String[][] building;
    static int[][] visited;

    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isEscape(int nowR, int nowC, int r, int c) {
        return nowR == 0 || nowR == r - 1 || nowC == 0 || nowC == c - 1;
    }

    public static int bfs(int nowR, int nowC, int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(nowR, nowC));

        visited[nowR][nowC] = 1;

        Queue<Coordinate> fire = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (Objects.equals(building[i][j], "*")) {
                    fire.offer(new Coordinate(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = fire.size();

            for (int i = 0; i < size; i++) {
                Coordinate temp = fire.poll();

                if (0 <= temp.r - 1 && Objects.equals(building[temp.r - 1][temp.c], ".")) {
                    building[temp.r - 1][temp.c] = "*";
                    fire.offer(new Coordinate(temp.r - 1, temp.c));
                }
                if (0 <= temp.c - 1 && Objects.equals(building[temp.r][temp.c - 1], ".")) {
                    building[temp.r][temp.c - 1] = "*";
                    fire.offer(new Coordinate(temp.r, temp.c - 1));
                }
                if (temp.r + 1 < r && Objects.equals(building[temp.r + 1][temp.c], ".")) {
                    building[temp.r + 1][temp.c] = "*";
                    fire.offer(new Coordinate(temp.r + 1, temp.c));
                }
                if (temp.c + 1 < c && Objects.equals(building[temp.r][temp.c + 1], ".")) {
                    building[temp.r][temp.c + 1] = "*";
                    fire.offer(new Coordinate(temp.r, temp.c + 1));
                }
            }

            size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate temp = queue.poll();

                building[temp.r][temp.c] = ".";

                if (isEscape(temp.r, temp.c, r, c)) {
                    return visited[temp.r][temp.c];
                } else {
                    if (visited[temp.r - 1][temp.c] == 0 && Objects.equals(building[temp.r - 1][temp.c], ".")) {
                        visited[temp.r - 1][temp.c] = visited[temp.r][temp.c] + 1;
                        building[temp.r - 1][temp.c] = "@";
                        queue.offer(new Coordinate(temp.r - 1, temp.c));
                    }
                    if (visited[temp.r][temp.c - 1] == 0 && Objects.equals(building[temp.r][temp.c - 1], ".")) {
                        visited[temp.r][temp.c - 1] = visited[temp.r][temp.c] + 1;
                        building[temp.r][temp.c - 1] = "@";
                        queue.offer(new Coordinate(temp.r, temp.c - 1));
                    }
                    if (visited[temp.r + 1][temp.c] == 0 && Objects.equals(building[temp.r + 1][temp.c], ".")) {
                        visited[temp.r + 1][temp.c] = visited[temp.r][temp.c] + 1;
                        building[temp.r + 1][temp.c] = "@";
                        queue.offer(new Coordinate(temp.r + 1, temp.c));
                    }
                    if (visited[temp.r][temp.c + 1] == 0 && Objects.equals(building[temp.r][temp.c + 1], ".")) {
                        visited[temp.r][temp.c + 1] = visited[temp.r][temp.c] + 1;
                        building[temp.r][temp.c + 1] = "@";
                        queue.offer(new Coordinate(temp.r, temp.c + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            building = new String[r][c];
            visited = new int[r][c];

            int nowR = 0;
            int nowC = 0;

            for (int j = 0; j < r; j++) {
                building[j] = br.readLine().split("");
                for (int k = 0; k < c; k++) {
                    if (Objects.equals(building[j][k], "@")) {
                        nowR = j;
                        nowC = k;
                    }
                }
            }

            int result = bfs(nowR, nowC, r, c);

            if (result == 0) {
                sb.append("IMPOSSIBLE");
            } else {
                sb.append(result);
            }

            if (i != N - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}