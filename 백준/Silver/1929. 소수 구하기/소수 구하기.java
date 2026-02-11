import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        br.close();

        boolean[] result = new boolean[N + 1]; // 기본 설정 false

        result[0] = true; // 0과 1은 제외
        result[1] = true;

        for (int i = 2; i <= N; i++) {
            if (!result[i]) {
                for (int j = i + i; j <= N; j += i) { //소수의 배수부터 N까지 제외
                    result[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!result[i]) {
                System.out.println(i);
            }
        }
    }
}