import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static String[][] video;
    static StringBuilder sb;

    public static void scale(int r, int c, int N) {
        boolean flag = true;

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (!Objects.equals(video[r][c], video[i][j])) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            sb.append(video[r][c]);
            return;
        }

        sb.append("(");

        scale(r, c, N / 2);
        scale(r, c + N / 2, N / 2);
        scale(r + N / 2, c, N / 2);
        scale(r + N / 2, c + N / 2, N / 2);

        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        video = new String[N][N];

        for (int i = 0; i < N; i++) {
            video[i] = br.readLine().split("");
        }

        sb = new StringBuilder();
        scale(0, 0, N);

        System.out.println(sb);
    }
}