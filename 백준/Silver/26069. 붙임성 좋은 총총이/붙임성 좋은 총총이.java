import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> list = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name1 = st.nextToken();
            String name2 = st.nextToken();
            if (Objects.equals(name1, "ChongChong") || Objects.equals(name2, "ChongChong")) {
                list.add(name1);
                list.add(name2);
            } else if (list.contains(name1)) {
                list.add(name2);
            } else if (list.contains(name2)) {
                list.add(name1);
            }
        }
        System.out.println(list.size());
    }
}