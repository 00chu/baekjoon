import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long result = 0;

    public static void bfs(long A, long B) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 0});

        while (!queue.isEmpty()) {
            long[] num = queue.poll();

            if (num[0] == B) {
                result = num[1];
                return;
            }

            if (num[0] * 2 <= B) {
                queue.add(new long[]{num[0] * 2, num[1] + 1});
            }

            if (num[0] * 10 + 1 <= B) {
                queue.add(new long[]{num[0] * 10 + 1, num[1] + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bfs(A, B);

        if (result != 0) {
            System.out.println(result + 1);
        } else {
            System.out.println(-1);
        }
    }
}