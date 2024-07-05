import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxSize = 1;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        String[][] rectangle = new String[N][M];

        for (int i = 0; i < N; i++) {
            rectangle[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    if (Objects.equals(rectangle[i][j], rectangle[i][k])) {
                        if (i + k - j < N && Objects.equals(rectangle[i][j], rectangle[i + k - j][j])
                                && Objects.equals(rectangle[i + k - j][j], rectangle[i + k - j][k])) {
                            if (maxSize < (k - j + 1) * (k - j + 1)) {
                                maxSize = (k - j + 1) * (k - j + 1);
                            }
                        }
                    }
                }
            }
        }

        br.close();
        System.out.println(maxSize);
    }
}