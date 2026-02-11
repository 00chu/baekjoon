import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        list[0] = Integer.parseInt(st.nextToken());
        int result = list[0];

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
            list[i] = Math.max(list[i - 1] + num, list[i]);
            if (result < list[i]) {
                result = list[i];
            }
        }
        
        System.out.println(result);
    }
}