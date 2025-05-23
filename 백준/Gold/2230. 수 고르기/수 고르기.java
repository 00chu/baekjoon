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

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int p1 = 0;
        int p2 = 0;
        int num = Integer.MAX_VALUE;

        while (num != M && (p1 < N && p2 < N)) {
            int temp = A[p2] - A[p1];
            if (temp < M) {
                p2++;
            } else {
                p1++;
            }
            if (temp >= M) {
                num = Math.min(num, temp);
            }
        }

        System.out.println(num);
    }
}