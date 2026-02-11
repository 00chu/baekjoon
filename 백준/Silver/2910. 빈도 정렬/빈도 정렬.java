import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> numbers = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        Integer[] temp = numbers.values().toArray(new Integer[0]);
        Arrays.sort(temp, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            while (true) {
                if (Objects.equals(numbers.get(list.get(index)), temp[i])) {
                    for (int k = 0; k < temp[i]; k++) {
                        sb.append(list.get(index)).append(" ");
                    }
                    list.remove(index);
                    index = 0;
                    break;
                } else {
                    index++;
                }
            }
        }

        System.out.println(sb);
    }
}
