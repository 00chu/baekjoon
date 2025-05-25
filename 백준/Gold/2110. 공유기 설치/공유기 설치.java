import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int homes[] = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int low = 0;
        int high = homes[N - 1];

        while (low <= high) {
            int count = 0;

            int mid = (low + high) / 2;

            int p = 0;
            for (int i = 0; i < N; i++) {
                if (mid <= homes[i] - homes[p]) {
                    p = i;
                    count++;
                }
            }
            count++;

            if (C <= count) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        System.out.println(high);
    }
}