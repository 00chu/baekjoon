import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] list;
    public static Integer[] result;

    public static void dfs(int v) { //새로운 매개변수를 추가
        visited[v] = true;

        for (int nextV : list[v]) {
            if (!visited[nextV]) {
                result[nextV] = v;
                dfs(nextV); //매개변수로 들어갈 수 지정
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        result = new Integer[N + 1];

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list[num1].add(num2);
            list[num2].add(num1);
        }

        StringBuilder sb = new StringBuilder();

        dfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(result[i]);
            if (i != N) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}