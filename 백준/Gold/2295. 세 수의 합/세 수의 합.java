import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                set.add(list[x] + list[y]);
            }
        }

        for (int k = N - 1; k >= 0; k--) {
            for (int z = 0; z < N; z++) {
                if (set.contains(list[k]-list[z])){
                    System.out.println(list[k]);
                    return;
                }
            }
        }
    }
}