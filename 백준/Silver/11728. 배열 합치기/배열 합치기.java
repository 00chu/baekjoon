import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[N + M];

        int p1 = 0;
        int p2 = 0;
        int index = 0;

        while (p1 < N && p2 < M) {
            if (A[p1] <= B[p2]) {
                list[index++] = A[p1++];
            } else {
                list[index++] = B[p2++];
            }
        }

        if (p1 == N) {
            while (p2 < M) {
                list[index++] = B[p2++];
            }
        }
        if (p2 == M) {
            while (p1 < N) {
                list[index++] = A[p1++];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}