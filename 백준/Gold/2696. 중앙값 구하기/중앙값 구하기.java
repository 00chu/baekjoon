import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            int num = (M + 1) / 2;

            ArrayList<Integer> list = new ArrayList<>();

            sb.append(num).append("\n");

            int lines = M / 10;
            if (M % 10 != 0) {
                lines++;
            }

            int index = 0;
            for (int j = 0; j < lines; j++) {
                if (j != 0 && index % 10 == 0) {
                    sb.append("\n");
                }
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    list.add(Integer.parseInt(st.nextToken()));
                    Collections.sort(list);
                    if (list.size() % 2 == 1) {
                        sb.append(list.get(index++)).append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}