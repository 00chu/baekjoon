import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        HashMap<String, Integer> list = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.put(br.readLine(), 0);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (list.containsKey(name)) {
                result.add(name);
                count++;
            }
        }

        Collections.sort(result);

        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);

    }
}