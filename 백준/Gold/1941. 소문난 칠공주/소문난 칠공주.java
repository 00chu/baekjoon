import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static String[][] graph;
    static int[] selected = new int[7];

    public static void combination(int count, int start, int S) {
        if (count - S > 3) {
            return;
        }

        if (count == 7 && S > 3) {
            bfs(selected[0] / 5, selected[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            selected[count] = i;
            if (Objects.equals(graph[r][c], "S")) {
                combination(count + 1, i + 1, S + 1);
            } else {
                combination(count + 1, i + 1, S);
            }
        }
    }

    static boolean[][] visited;
    static int[] rList = {-1, 1, 0, 0};
    static int[] cList = {0, 0, -1, 1};

    static int result = 0;

    public static void bfs(int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(r, c));

        visited = new boolean[5][5];
        visited[r][c] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = coordinate.r + rList[i];
                int column = coordinate.c + cList[i];

                if (row < 0 || 4 < row || column < 0 || 4 < column) continue;

                for (int j = 1; j < 7; j++) {
                    if (!visited[selected[j] / 5][selected[j] % 5] && selected[j] == row * 5 + column) {
                        visited[selected[j] / 5][selected[j] % 5] = true;
                        count++;
                        queue.offer(new Coordinate(selected[j] / 5, selected[j] % 5));
                    }
                }
            }
        }
        if (count == 7) {
            result++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new String[5][5];

        for (int i = 0; i < 5; i++) {
            graph[i] = br.readLine().split("");
        }

        combination(0, 0, 0);

        System.out.println(result);
    }
}