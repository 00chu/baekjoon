import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int max = 0;
    public static int last = 0;

    public static void dfs(ArrayList<Node>[] list, int s, int sum) {
        visited[s] = true;
        if (sum > max) {
            max = sum;
            last = s;
        }

        ArrayList<Node> temp = list[s];
        for (Node value : temp) {
            if (!visited[value.data]) {
                dfs(list, value.data, sum + value.weight);
            }
        }
    }

    public static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < V + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int data = Integer.parseInt(st.nextToken());
                if (data == -1) {
                    break;
                } else {
                    int weight = Integer.parseInt(st.nextToken());
                    list[num].add(new Node(data, weight));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (list[i].size() == 1) {
                visited = new boolean[V + 1];
                dfs(list, i, 0);
                break;
            }
        }

        visited = new boolean[V + 1];
        dfs(list, last, 0);

        System.out.println(max);
    }
}