import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arrA = br.readLine().toCharArray();
        char[] arrB = br.readLine().toCharArray();

        int[][] count = new int[arrA.length + 1][arrB.length + 1];

        for (int i = 1; i < arrA.length + 1; i++) {
            for (int j = 1; j < arrB.length + 1; j++) {
                if (arrA[i - 1] == arrB[j - 1]) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                } else {
                    if (count[i][j - 1] > count[i - 1][j]) {
                        count[i][j] = count[i][j - 1];
                    } else {
                        count[i][j] = count[i - 1][j];
                    }
                }
            }
        }
        System.out.println(count[arrA.length][arrB.length]);
    }
}