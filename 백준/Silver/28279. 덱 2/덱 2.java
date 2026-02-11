import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1: {
                    int num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                }
                case 2: {
                    int num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                }
                case 3: {
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                }
                case 4: {
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                }
                case 5: {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case 6: {
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                }
                case 7: {
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                }
                case 8: {
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
                }
            }
        }
        br.close();

        System.out.println(sb);
    }
}