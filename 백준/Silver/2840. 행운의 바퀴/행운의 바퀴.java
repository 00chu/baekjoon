import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] list = new String[N];
        int index = N - 1;
        boolean flag = false;

        HashSet<String> alphabetList = new HashSet<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            String alphabet = st.nextToken();

            for (int j = 0; j < num; j++) {
                index--;
                if (index == -1) {
                    index = N - 1;
                }
            }

            if (list[index] == null && !alphabetList.contains(alphabet)) {
                list[index] = alphabet;
                alphabetList.add(alphabet);
            } else if (Objects.equals(list[index], alphabet)) {
                list[index] = alphabet;
            } else {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("!");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (index == N) {
                index = 0;
            }
            if (list[index] == null) {
                sb.append("?");
            } else {
                sb.append(list[index]);
            }
            index++;
        }

        System.out.println(sb);
    }
}
