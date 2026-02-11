import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int row;
        int column;
        int height;

        public Node(int row, int column, int height) {
            this.row = row;
            this.column = column;
            this.height = height;
        }
    }

    static int[] row = {-1, 0, 1, 0};
    static int[] column = {0, -1, 0, 1};
    static int[] height = {-1, 1};

    public static int[][][] box;

    public static int tomato;
    public static int date = 0;

    public static Queue<Node> queue = new LinkedList<>();

    public static void bfs(int N, int M, int H) {
        boolean[][][] visited = new boolean[N][M][H];

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            visited[temp.row][temp.column][temp.height] = true;
            tomato--;

            for (int i = 0; i < 4; i++) {
                int r = temp.row + row[i];
                int c = temp.column + column[i];
                int h = temp.height;

                if (0 > r || r >= N || 0 > c || c >= M || visited[r][c][h]) {
                    continue;
                }

                if (box[r][c][h] == 0) {
                    box[r][c][h] = box[temp.row][temp.column][temp.height] + 1;
                    queue.add(new Node(r, c, h));

                    date = Math.max(date, box[r][c][h]);
                }
            }

            for (int i = 0; i < 2; i++) {
                int h = temp.height + height[i];

                if (0 > h || h >= H || visited[temp.row][temp.column][h]) {
                    continue;
                }

                if (box[temp.row][temp.column][h] == 0) {
                    box[temp.row][temp.column][h] = box[temp.row][temp.column][temp.height] + 1;
                    queue.add(new Node(temp.row, temp.column, h));

                    date = Math.max(date, box[temp.row][temp.column][h]);
                }
            }
        }
        date -= 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        box = new int[N][M][H];

        int ripenTomato = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    box[j][k][i] = Integer.parseInt(st.nextToken());
                    if (box[j][k][i] == 1) {
                        queue.add(new Node(j, k, i));
                        ripenTomato++;
                    } else if (box[j][k][i] == 0) {
                        tomato++;
                    }
                }
            }
        }

        if (tomato == 0) {
            System.out.println(0);
            return;
        }

        bfs(N, M, H);

        if (tomato + ripenTomato != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(date);

        br.close();
    }
}