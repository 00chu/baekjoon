import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static int N;

    public static boolean[] before;
    public static boolean[] after;
    public static boolean[] temp;

    public static void trigger(int num) {
        if (num == N - 1) {
            for (int i = 2; i > 0; i--) {
                temp[N - i] = !temp[N - i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                temp[num - 1 + i] = !temp[num - 1 + i];
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            if (temp[i] != after[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        before = new boolean[N];
        after = new boolean[N];

        String[] s = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            before[i] = !Objects.equals(s[i], "0");
        }

        s = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            after[i] = !Objects.equals(s[i], "0");
        }

        //  처음 부분을 바꾸지 않은 버전
        temp = before.clone();
        int num1 = 0;
        for (int i = 1; i < N; i++) {
            if (temp[i - 1] != after[i - 1]) {
                trigger(i);
                num1++;
            }
        }

        boolean flag1;
        flag1 = check();


        //  처음 부분을 바꾼 버전
        int num2 = 1;
        temp = before.clone();
        temp[0] = !before[0];
        temp[1] = !before[1];

        for (int i = 1; i < N; i++) {
            if (temp[i - 1] != after[i - 1]) {
                trigger(i);
                num2++;
            }
        }

        boolean flag2;
        flag2 = check();

        //  결과
        if (flag1 && flag2) {
            System.out.println(Math.min(num1, num2));
        } else if (flag1) {
            System.out.println(num1);
        } else if (flag2) {
            System.out.println(num2);
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}