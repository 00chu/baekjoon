import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int min = 100001;

        int[] sum = new int[N];
        int temp = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            temp += num;
            sum[i] = temp;
            if (num == S) {
                min = 1;
            }
        }

        int left = 0;
        int right = 1;

        if (min != 1) {
            while (left < right && right <= N - 1) {
                if (sum[right] >= S) {
                    if (min > right - left + 1) {
                        min = right - left + 1;
                    }

                    while (left < right && sum[right] - sum[left] >= S) {
                        if (min > right - left) {
                            min = right - left;
                        }
                        left++;
                    }

                    right++;
                } else {
                    right++;
                }
            }
        }

        if (min == 100001) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}