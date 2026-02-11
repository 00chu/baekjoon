import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            BigInteger result = new BigInteger(String.valueOf(Long.parseLong(br.readLine())));
            if (result.isProbablePrime(10)){
                System.out.println(result);
            }else{
                System.out.println(result.nextProbablePrime());
            }
        }

        br.close();
    }
}