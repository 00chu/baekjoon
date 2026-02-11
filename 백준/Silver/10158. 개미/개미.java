import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int xTime = t % (2 * w);
        int yTime = t % (2 * h);

        boolean xFlag = false;
        boolean yFlag = false;

        for (int i = 0; i < xTime; i++) {
            if (p == w) {
                xFlag = true;
            } else if (p == 0) {
                xFlag = false;
            }

            if (xFlag) {
                p--;
            } else {
                p++;
            }
        }

        for (int i = 0; i < yTime; i++) {
            if (q == h) {
                yFlag = true;
            } else if (q == 0) {
                yFlag = false;
            }

            if (yFlag) {
                q--;
            } else {
                q++;
            }
        }

        System.out.println(p + " " + q);
    }
}