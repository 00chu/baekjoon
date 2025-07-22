import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.zip.CRC32;

public class Main {
    static int[][] paper;
    static int[] result;

    public static void cut(int r, int c, int N) {
        boolean flag = true;

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (!Objects.equals(paper[r][c], paper[i][j])) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            if (paper[r][c] == -1) {
                result[0]++;
            } else if (paper[r][c] == 0) {
                result[1]++;
            } else {
                result[2]++;
            }
            return;
        }

        for (int i = r; i < r + N; i += N / 3) {
            for (int j = c; j < c + N; j += N / 3) {
                cut(i, j, N / 3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[3];

        cut(0, 0, N);

        for (int n : result) {
            System.out.println(n);
        }
    }
}