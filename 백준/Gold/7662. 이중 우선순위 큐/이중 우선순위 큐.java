import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String order = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    maxQueue.offer(n);
                    minQueue.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (!map.isEmpty()) {
                    if (n == 1) {
                        while (!maxQueue.isEmpty()) {
                            int num = maxQueue.poll();
                            int temp = map.getOrDefault(num, 0);
                            if (temp != 0) {
                                if (temp == 1) {
                                    map.remove(num);
                                } else{
                                    map.put(num, temp - 1);
                                }
                                break;
                            }
                        }
                    } else {
                        while (!minQueue.isEmpty()) {
                            int num = minQueue.poll();
                            int temp = map.getOrDefault(num, 0);
                            if (temp != 0) {
                                if (temp == 1) {
                                    map.remove(num);
                                } else {
                                    map.put(num, temp - 1);
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                while (!maxQueue.isEmpty()) {
                    int num = maxQueue.poll();
                    int temp = map.getOrDefault(num, 0);
                    if (temp != 0) {
                        sb.append(num);
                        break;
                    }
                }
                sb.append(" ");
                while (!minQueue.isEmpty()) {
                    int num = minQueue.poll();
                    int temp = map.getOrDefault(num, 0);
                    if (temp != 0) {
                        sb.append(num);
                        break;
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}