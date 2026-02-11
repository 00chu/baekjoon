import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] crane = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, Comparator.reverseOrder());

        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Collections.reverseOrder());


        if (crane[0] < box.get(0)) {
            System.out.println(-1);
            return;
        }


        int count = 0;

        while (!box.isEmpty()) {
            int i = 0;
            int j = 0;
            while (i < N) {
                if (crane[i] >= box.get(j)) {
                    box.remove(j);
                    i++;
                } else {
                    j++;
                }
                if (j == box.size()) {
                    break;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}