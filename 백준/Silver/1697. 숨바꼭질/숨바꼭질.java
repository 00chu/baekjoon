import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited;

    public static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        visited[N] = 1;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == K) {
                return;
            }

            int next;

            next = num + 1;
            if (next <= 100000 && visited[next] == 0) {
                visited[next] = visited[num] + 1;
                queue.offer(next);
            }
            next = num - 1;
            if (0 <= next && visited[next] == 0) {
                visited[next] = visited[num] + 1;
                queue.offer(next);
            }
            next = num * 2;
            if (next <= 100000 && visited[next] == 0) {
                visited[next] = visited[num] + 1;
                queue.offer(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        visited = new int[100001];

        bfs(N, K);

        System.out.println(visited[K]-1);
    }
}