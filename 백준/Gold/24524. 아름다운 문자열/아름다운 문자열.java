import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        char[] result = br.readLine().toCharArray();

        int[] list = new int[result.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (arr[i] == result[j]) {
                    if (j == 0 || list[j - 1] > list[j]) {
                        list[j]++;
                    }
                }
            }
        }

        System.out.println(list[result.length-1]);
    }
}