import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        if (list[0] + list[1] > list[2]) {
            System.out.println(list[0] + list[1] + list[2]);
        } else {
            System.out.println(list[0] + list[1] + (list[0] + list[1] - 1));
        }
    }
}