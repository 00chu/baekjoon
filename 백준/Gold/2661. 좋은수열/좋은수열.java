import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] list;
    static StringBuilder result;
    static boolean endFlag = false;

    public static void dfs(int N, int index) {
        if (result.length() != 0) {
            return;
        }

        if (index == N) {
            for (int n : list) {
                result.append(n);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            list[index] = i;

            String s = "";
            for (int j = 0; j <= index; j++) {
                s += list[j];
            }
          
            boolean flag = true;
            for (int j = 0; j < s.length() / 2; j++) {
                if (s.substring(index - j, index + 1)
                        .equals(s.substring(index - j * 2 - 1, index - j)) || list[index - 1] == list[index]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                dfs(N, index + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new int[N];

        result = new StringBuilder();

        dfs(N, 0);

        System.out.println(result);
    }
}