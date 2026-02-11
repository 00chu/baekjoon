import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] list;
    public static int[] result;

    public static void dfs(int v, int R) { //새로운 매개변수를 추가
        visited[v] = true;
        if (list[v].size() == 1 && v != R) {
            result[v] = 1;
        } else {
            result[v] += 1;
        }

        for (int nextV : list[v]) {
            if (!visited[nextV]) {
                dfs(nextV, R); //매개변수로 들어갈 수 지정
                result[v] += result[nextV];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list[num1].add(num2);
            list[num2].add(num1);
        }

        dfs(R, R);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            sb.append(result[Integer.parseInt(br.readLine())]);
            if (i < Q - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}