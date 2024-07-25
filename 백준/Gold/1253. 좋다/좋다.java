import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        for (int i = 0; i < N; i++) {
            int num1 = 0;
            int num2 = N - 1;
            while (true) {
                if (num1 == i) {
                    num1++;
                } else if (num2 == i) {
                    num2--;
                }

                if (num1 >= num2) {
                    break;
                }
                
                if (arr.get(num1) + arr.get(num2) < arr.get(i)) {
                    num1++;
                } else if (arr.get(num1) + arr.get(num2) > arr.get(i)) {
                    num2--;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}