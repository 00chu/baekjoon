import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");

            ArrayList<Integer> list = new ArrayList<>();

            int count = 0;

            for (int j = 0; j < 20; j++) {
                list.add(Integer.parseInt(st.nextToken()));
                for (int k = 0; k <= j; k++) {
                    if (list.get(j) < list.get(k)) {
                        list.add(k, list.remove(j));
                        count+=j-k;
                    }
                }
            }
            
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
