import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    static boolean[] visited;
    static int max = 0;

    public static void dfs(ArrayList<Node> list[], int s, int sum) {
        visited[s] = true;
        max = Math.max(max, sum);

        ArrayList<Node> temp = list[s];
        for (int i = 0; i < temp.size(); i++) {
            if (!visited[temp.get(i).data]) {
                dfs(list, temp.get(i).data, sum + temp.get(i).weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        ArrayList<Node>[] list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, value));
            list[child].add(new Node(parent, value));
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(list, i, 0);
        }

        System.out.println(max);
    }
}