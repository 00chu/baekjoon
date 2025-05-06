import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        double sum = 0;

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            map.put(list[i], map.getOrDefault(list[i], 0) + 1);
            sum += list[i];
        }

        Arrays.sort(list);

        if (N == 1) {
            String result = list[0] + "\n" + // 산술 평균
                    list[0] + "\n" + // 중앙값
                    list[0] + "\n" + // 최빈값
                    0; // 범위

            System.out.println(result);
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Math.round(sum / N)).append("\n"); // 산술 평균

        sb.append(list[N / 2]).append("\n"); // 중앙값

        List<Integer> temp = new ArrayList<>(map.values());
        Collections.sort(temp);

        ArrayList<Integer> result = new ArrayList<>();

        for (int key : map.keySet()) {
            if (Objects.equals(map.get(key), temp.get(temp.size() - 1))) {
                result.add(key);
            }
        }

        Collections.sort(result);

        if (result.size() <= 1) {
            sb.append(result.get(0)).append("\n"); // 최빈값
        } else {
            sb.append(result.get(1)).append("\n"); // 최빈값
        }

        sb.append(list[N - 1] - list[0]); // 범위

        System.out.println(sb);
    }
}