import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static String[] list;
    static boolean[] visited;
    static String[] temp;

    static StringBuilder sb;

    public static void dfs(int v, int L, int depth) {
        if (depth == L) {
            int num1 = 0;
            int num2 = 0;
            for (int i = 0; i < L; i++) {
                String s = temp[i];
                if (Objects.equals(s, "a") || Objects.equals(s, "e") ||
                        Objects.equals(s, "i") || Objects.equals(s, "o") ||
                        Objects.equals(s, "u")) {
                    num1++;
                } else {
                    num2++;
                }
                if (num1 >= 1 && num2 >= 2) {
                    break;
                }
            }

            if (num1 >= 1 && num2 >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(temp[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = v; i < list.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = list[i];
                dfs(i + 1, L, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        list = new String[C];
        temp = new String[L];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken();
        }

        Arrays.sort(list);

        dfs(0, L, 0);

        System.out.println(sb);
    }
}