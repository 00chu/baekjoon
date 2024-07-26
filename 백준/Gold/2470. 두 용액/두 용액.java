import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = 2000000000;
        int left = 0;
        int right = N - 1;

        int num1 = 0, num2 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        if (0 <= list[left]) {
            num1 = left;
            num2 = left + 1;
        } else if (list[right] <= 0) {
            num1 = right-1;
            num2 = right;
        } else {
            while (left<right) {
                int temp = list[left] + list[right];

                if (temp == 0) {
                    num1 = left;
                    num2 = right;
                    break;
                }

                if (min > Math.abs(temp)) {
                    min = Math.abs(temp);
                    num1 = left;
                    num2 = right;
                }
                if (Math.abs(list[left]) < Math.abs(list[right])) {
                    right--;
                } else {
                    left++;

                }
            }
        }

        System.out.println(list[num1] + " " + list[num2]);
    }
}