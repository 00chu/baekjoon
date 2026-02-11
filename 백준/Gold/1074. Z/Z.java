import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int num = 0;

    public static void repeatZ(int N, int r, int c) {
        boolean rFlag = false;
        boolean cFlag = false;

        if (r < (int) Math.pow(2, (N - 1))) {
            rFlag = true;
        }
        if (c < (int) Math.pow(2, (N - 1))) {
            cFlag = true;
        }

        if (N == 0) {
            return;
        }

        if (rFlag && cFlag) {
            num += 0 * (int) Math.pow((int) Math.pow(2, (N - 1)), 2);
            repeatZ(N - 1, r, c);
        } else if (rFlag) {
            num += 1 * (int) Math.pow((int) Math.pow(2, (N - 1)), 2);
            repeatZ(N - 1, r, c - (int) Math.pow(2, (N - 1)));
        } else if (cFlag) {
            num += 2 * (int) Math.pow((int) Math.pow(2, (N - 1)), 2);
            repeatZ(N - 1, r - (int) Math.pow(2, (N - 1)), c);
        } else {
            num += 3 * (int) Math.pow((int) Math.pow(2, (N - 1)), 2);
            repeatZ(N - 1, r - (int) Math.pow(2, (N - 1)), c - (int) Math.pow(2, (N - 1)));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        repeatZ(N, r, c);

        System.out.println(num);
    }
}