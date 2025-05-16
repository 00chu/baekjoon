import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] high = new int[N];

        for (int i = 0; i < N; i++) {
            high[i] = Integer.parseInt(st.nextToken());
        }

        int[] orders = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            orders[a - 1] += k;
            orders[b] -= k;
        }


        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < N; i++) {
            num += orders[i];
            sb.append(high[i] + num).append(" ");
        }
        
        System.out.println(sb);
    }
}