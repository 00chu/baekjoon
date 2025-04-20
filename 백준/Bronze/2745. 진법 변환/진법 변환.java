import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result = 0;
        int temp = 1;

        for (int i = N.length() - 1; i >= 0; i--) {
            if (65 <= N.charAt(i)) {
                result += (N.charAt(i) - 55) * temp;
            } else {
                result += (N.charAt(i) - 48) * temp;
            }
            temp *= B;
        }

        System.out.println(result);
    }
}