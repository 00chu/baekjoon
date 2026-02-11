import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> book = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            book.put(name, book.getOrDefault(name, 0) + 1);
        }

        Integer[] best = book.values().toArray(new Integer[0]);
        Arrays.sort(best, Collections.reverseOrder());

        ArrayList<String> result = new ArrayList<>();

        for (String key : book.keySet()) {
            if (Objects.equals(book.get(key), best[0])) {
                result.add(key);
            }
        }

        if (result.size() != 1) {
            Collections.sort(result);
        }
        System.out.println(result.get(0));
    }
}
