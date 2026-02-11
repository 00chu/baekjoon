import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] num = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);

            int min = Integer.MAX_VALUE;
            int count = 0;

            int s = 0;
            int e = n - 1;

            while (s != e) {
                int temp = Math.abs((num[s] + num[e]) - k);
                if ((num[s] + num[e]) - k>0){
                    e--;
                }else {
                    s++;
                }
                if (min == temp) {
                    count++;
                } else if (min > temp) {
                    min = temp;
                    count = 1;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
