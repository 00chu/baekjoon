import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (leftQueue.size() == rightQueue.size()) {
                leftQueue.offer(num);
            } else {
                rightQueue.offer(num);
            }

            if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                if (leftQueue.peek() > rightQueue.peek()) {
                    int temp = leftQueue.poll();
                    leftQueue.offer(rightQueue.poll());
                    rightQueue.offer(temp);
                }

            }
            sb.append(leftQueue.peek()).append("\n");
        }

        System.out.println(sb);
    }
}