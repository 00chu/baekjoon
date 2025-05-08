import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        String[] list = count.keySet().toArray(new String[0]);

        Arrays.sort(list); // 사전 순서
        Arrays.sort(list, Comparator.comparingInt(String::length).reversed()); // 단어 길이
        Arrays.sort(list, (o1, o2) -> { // 단어 횟수
            return count.get(o2) - count.get(o1);
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
