import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited = new int[100001];
    static int count = 0;
    static int min = 100001;

    public static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        visited[N] = 1;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (min < visited[num]) {
                return;
            }

            int next;

            next = num - 1;
            if (0 <= next) {
                if (next == K) {
                    min = visited[num];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[num] + 1) {
                    visited[next] = visited[num] + 1;
                    queue.offer(next);
                }
            }

            next = num + 1;
            if (next <= 100000) {
                if (next == K) {
                    min = visited[num];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[num] + 1) {
                    visited[next] = visited[num] + 1;
                    queue.offer(next);
                }
            }

            next = num * 2;
            if (next <= 100000) {
                if (next == K) {
                    min = visited[num];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[num] + 1) {
                    visited[next] = visited[num] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K + "\n" + "1");
            return;
        }

        bfs(N, K);

        System.out.println(min + "\n" + count);
    }
}