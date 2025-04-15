import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int[] result;

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node o) -> o.weight));
        result[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node num = queue.poll();

            if (!visited[num.data]) {
                visited[num.data] = true;
                for (int i = 0; i < list[num.data].size(); i++) {
                    if (!visited[list[num.data].get(i).data]) {
                        result[list[num.data].get(i).data] = Math.min(num.weight + list[num.data].get(i).weight, result[list[num.data].get(i).data]);
                        queue.offer(new Node(list[num.data].get(i).data, result[list[num.data].get(i).data]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        result = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }
}