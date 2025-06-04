import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Document {
        int importance;
        int number;

        public Document(int importance, int number) {
            this.importance = importance;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new Document(num, j));
                maxQueue.offer(num);
            }

            if (N == 1) {
                sb.append(1);
            } else {
                int count = 1;
                while (!queue.isEmpty()) {
                    if (maxQueue.peek() == queue.peek().importance) {
                        if (queue.poll().number == M) {
                            sb.append(count);
                            break;
                        }
                        maxQueue.poll();
                        count++;
                    } else {
                        queue.offer(queue.poll());
                    }
                }
            }
            if (i < T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}