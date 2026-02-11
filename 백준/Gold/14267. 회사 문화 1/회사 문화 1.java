import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] list;
    public static int[] result;
    public static int[] sum;

    public static void dfs(int i) {
        for (int nextV : list[i]) {
            sum[nextV] += sum[i];
            dfs(nextV); //매개변수로 들어갈 수 지정
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        result = new int[n + 1];
        sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num > 0) {
                list[num].add(i);
            }
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            sum[i] += w;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(sum[i]).append(" ");
        }

        System.out.println(sb);
    }
}