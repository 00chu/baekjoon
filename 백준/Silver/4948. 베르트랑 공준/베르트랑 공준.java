import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] result = new boolean[246913]; // 기본 설정 false, 최대로 필요한 수

        while (true) {
            int count = 0;
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            result[0] = true; // 0과 1은 제외
            result[1] = true;

            for (int i = 2; i <= 2*n; i++) {
                if (!result[i]) {
                    for (int j = i + i; j <= 2*n; j += i) { //소수의 배수부터 N까지 제외
                        result[j] = true;
                    }
                }
            }
            for (int i = n+1; i <= 2*n; i++){
                if (!result[i]){
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}