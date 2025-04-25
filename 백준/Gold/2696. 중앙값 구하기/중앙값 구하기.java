import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
            PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());

            sb.append((M + 1) / 2).append("\n");
            int index = 0;

            int lines = M / 10;
            if (M % 10 != 0) {
                lines++;
            }

            for (int j = 0; j < lines; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    if (minQueue.size() == maxQueue.size()) {
                        maxQueue.offer(Integer.parseInt(st.nextToken()));
                    } else {
                        minQueue.offer(Integer.parseInt(st.nextToken()));
                    }

                    if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
                        if (minQueue.peek() > maxQueue.peek()) {
                            minQueue.add(maxQueue.poll());
                            maxQueue.add(minQueue.poll());
                        }
                    }
                    index++;

                    if (index % 2 == 1) {
                        sb.append(maxQueue.peek()).append(" ");
                    }
                    if (index % 20 == 0) {
                        sb.append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}