import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Staff {
        String name;
        double score;

        public Staff(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Staff> list = new ArrayList<>();
        double endLine = X * 0.05;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (score >= endLine) {
                list.add(new Staff(name, score));
            }
        }

        list.sort(Comparator.comparing(o -> o.name));

        Map<Double, String> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j <= 14; j++) {
                map.put(list.get(i).score / j, list.get(i).name);
            }
        }

        Double[] scores = map.keySet().toArray(new Double[0]);
        Arrays.sort(scores, Collections.reverseOrder());

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            result.put(list.get(i).name, 0);
        }

        for (int i = 0; i < 14; i++) {
            result.put(map.get(scores[i]), (result.get(map.get(scores[i])) + 1));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).name).append(" ").append(result.get(list.get(i).name)).append("\n");
        }

        System.out.println(sb);
    }
}
