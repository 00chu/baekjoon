import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    static String[] list;
    static ArrayList<String> result;
    static boolean flag = false;
    static StringBuilder sb;

    public static void dfs(int N, int index) {
        if (flag) {
            return;
        }

        if (result.size() == N) {
            int[] temp = result.stream().mapToInt(Integer::parseInt).toArray();
            Arrays.sort(temp);

            for (int i = 0; i < N; i++) {
                if (temp[i] != i + 1) {
                    sb.setLength(0);
                    return;
                }
                sb.append(result.get(i)).append(" ");
            }
            flag = true;
            return;
        }

        if (index >= list.length) {
            return;
        }


        if (!Objects.equals(list[index], "0") && !result.contains(list[index])) {
            result.add(list[index]);
            if (index < list.length) {
                dfs(N, index + 1);
            }
            result.remove(list[index]);
        }

        if (!Objects.equals(list[index], "0") && index < list.length - 1) {
            String temp = list[index] + list[index + 1];
            if (Integer.parseInt(temp) <= 50 && !result.contains(temp)) {
                result.add(temp);
                dfs(N, index + 2);
                result.remove(temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = br.readLine().split("");

        int N = 0;

        if (list.length <= 9) {
            N += list.length;
        } else {
            N += (list.length - 9) / 2 + 9;
        }

        result = new ArrayList<>();
        sb = new StringBuilder();

        dfs(N, 0);

        System.out.print(sb);
    }
}