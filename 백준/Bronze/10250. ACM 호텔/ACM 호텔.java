import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (N % H == 0) {
                sb.append(H);
            } else {
                sb.append(N % H);
            }

            if (N % H == 0) {
                if (N / H < 10) {
                    sb.append(0).append(N / H).append("\n");
                } else {
                    sb.append(N / H).append("\n");
                }
            } else {
                if (N / H+1 < 10) {
                    sb.append(0).append(N / H + 1).append("\n");
                } else {
                    sb.append(N / H + 1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
