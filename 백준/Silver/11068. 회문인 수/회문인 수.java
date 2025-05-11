import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean result = false;

            for (int j = 2; j <= 64; j++) {
                int tempN = N;
                ArrayList<Integer> list = new ArrayList<>();

                while (true) {
                    list.add(tempN % j);
                    tempN /= j;
                    if (tempN / j == 0) {
                        list.add(tempN % j);
                        break;
                    }
                }

                int s = 0;
                int e = list.size() - 1;

                while (true) {
                    if (!Objects.equals(list.get(s), list.get(e))) {
                        break;
                    }else if (Objects.equals(list.get(s), list.get(e))&&(s == e || s == e - 1)){
                        result = true;
                        break;
                    }
                    s++;
                    e--;
                }

                if (result) {
                    System.out.println(1);
                    break;
                }
            }

            if (!result) {
                System.out.println(0);
            }
        }
    }
}
