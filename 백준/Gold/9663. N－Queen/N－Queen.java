import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] board;
    static int result = 0;

    public static void dfs(int N, int index) {
        if (index == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[index] = i;

            boolean flag = true;

            for (int j = 0; j < index; j++) {
                if (board[index] == board[j] || Math.abs(index - j) == Math.abs(board[index] - board[j])) {
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

        board = new int[N];

        dfs(N, 0);

        System.out.println(result);
    }
}