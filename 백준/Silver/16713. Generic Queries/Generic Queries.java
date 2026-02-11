import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];

        int[] xor = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            a[i] = Integer.parseInt(st.nextToken());

            xor[i] = xor[i - 1] ^ a[i];
        }

        int result = 0;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            result ^= xor[s - 1] ^ xor[e];
        }

        System.out.println(result);
    }
}