import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();

    static void fibonacci(int n) { //피보나치
        arr.add(0);
        arr.add(1);

        for (int i = 1; i < n; i++) {
            int sum = arr.get(arr.size() - 2) + arr.get(arr.size() - 1);
            arr.add(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);

            if (N == 0) {
                System.out.println("1 0");
            } else if (N == 1) {
                System.out.println("0 1");
            } else {
                System.out.println(arr.get(arr.size() - 2) + " " + arr.get(arr.size() - 1));
            }
        }

        br.close();
    }
}