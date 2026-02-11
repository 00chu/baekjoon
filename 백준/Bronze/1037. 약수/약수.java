import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 1000000, max = 0;
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (min > temp) {
                min = temp;
            }

            if (max < temp) {
                max = temp;
            }
        }

        System.out.println(min * max);
    }
}