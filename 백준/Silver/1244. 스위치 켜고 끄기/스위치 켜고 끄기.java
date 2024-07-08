import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }


        int student = Integer.parseInt(br.readLine());

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                int j = num - 1;

                while (j < N) {
                    if (list[j] == 0) {
                        list[j] = 1;
                    } else {
                        list[j] = 0;
                    }
                    j += num;
                }
            } else {
                int count = 0;
                while ((0 <= num - count - 1 && num + count - 1 < N)
                        && (list[num - count - 1] == list[num + count - 1])) {
                    count++;
                }

                for (int j = num - count; j < num - 1 + count; j++) {
                    if (list[j] == 0) {
                        list[j] = 1;
                    } else {
                        list[j] = 0;
                    }
                }
            }
        }

        int count = 0;
        for (int n : list) {
            sb.append(n).append(" ");
            count++;
            if(count==20){
                sb.append("\n");
                count=0;
            }
        }

        System.out.print(sb);
    }
}