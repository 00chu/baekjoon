import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        boolean[] temp = new boolean[N + 1]; // 기본 설정 false
        ArrayList<Integer> primeNumber = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (!temp[i]) {
                primeNumber.add(i);
                for (int j = i + i; j <= N; j += i) { //소수의 배수부터 N까지 제외
                    temp[j] = true;
                }
            }
        }

        int sum = 0;
        int p2 = 0;

        for (int p1 = 0; p1 < primeNumber.size(); p1++) {
            sum += primeNumber.get(p1);
            if(p1==primeNumber.size()-1){
                if (primeNumber.get(primeNumber.size()-1) == N) {
                    result++;
                }
                break;
            }
            while (p2 <= p1 && sum >= N) {
                if (sum == N) {
                    result++;
                }
                sum -= primeNumber.get(p2);
                p2++;
            }
        }

        System.out.println(result);
    }
}