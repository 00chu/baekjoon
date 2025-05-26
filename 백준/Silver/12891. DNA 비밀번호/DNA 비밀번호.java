import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int result = 0;
    public static int index = 0;

    public static void checkList(String[] dna, int[] list, int[] check) {
        boolean flag = true;

        for (int i = 0; i < 4; i++) {
            if (list[i] < check[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            result++;
        }

        switch (dna[index]) {
            case "A":
                list[0]--;
                break;
            case "C":
                list[1]--;
                break;
            case "G":
                list[2]--;
                break;
            case "T":
                list[3]--;
                break;
        }
        index++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String[] dna = br.readLine().split("");

        st = new StringTokenizer(br.readLine());
        int[] check = new int[4];
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[4];

        for (int i = 0; i < S; i++) {
            switch (dna[i]) {
                case "A":
                    list[0]++;
                    break;
                case "C":
                    list[1]++;
                    break;
                case "G":
                    list[2]++;
                    break;
                case "T":
                    list[3]++;
                    break;
            }
            if (i >= P - 1) {
                checkList(dna, list, check);
            }
        }

        System.out.println(result);
    }
}