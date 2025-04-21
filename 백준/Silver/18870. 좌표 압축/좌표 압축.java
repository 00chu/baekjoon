import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[N];
        int[] temp = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            list[i] = num;
            temp[i] = num;
        }

        Arrays.sort(temp);

        for (int i = 0; i < N; i++) {
            if(!map.containsKey(temp[i])){
                map.put(temp[i], map.size());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(list[i])).append(" ");
        }

        System.out.println(sb);
    }
}