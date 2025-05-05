import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int number;
        int index;

        public Node(int number, int index){
            this.number = number;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Node> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.offer(new Node(num, i));
        }

        StringBuilder sb = new StringBuilder();
        Node node = deque.poll();
        sb.append(1).append(" ");

        while (!deque.isEmpty()) {
            if (node.number > 0) {
                if (node.number % deque.size()>0) {
                    node.number %= deque.size();
                }
                for (int i = 0; i < node.number - 1; i++) {
                    deque.offer(deque.poll());
                }
                node = deque.poll();
                sb.append(node.index).append(" ");
            } else {
                if (Math.abs(node.number) % deque.size()>0) {
                    node.number = Math.abs(node.number) % deque.size();
                }else {
                    node.number = Math.abs(node.number);
                }
                for (int i = 0; i < node.number - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                node = deque.pollLast();
                sb.append(node.index).append(" ");
            }
            if (deque.size() == 1) {
                sb.append(deque.poll().index).append(" ");
            }
        }

        System.out.println(sb);
    }
}