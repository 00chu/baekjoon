import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<BigInteger> arr = new ArrayList<>();

    static void fibonacci(int n) { //피보나치
        arr.add(BigInteger.valueOf(0));
        arr.add(BigInteger.valueOf(1));

        for (int i = 1; i < n; i++) {
            BigInteger sum = arr.get(arr.size() - 2).add(arr.get(arr.size() - 1));
            arr.add(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //테스트 케이스

        fibonacci(n);

        if (n == 0) {
            System.out.println("0");
        } else if (n == 1) {
            System.out.println("1");
        } else {
            System.out.println(arr.get(arr.size() - 1));
        }
    }
}