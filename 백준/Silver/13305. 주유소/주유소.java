import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] road = new long[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        long[] gasStation = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gasStation[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;

        for (int i = 0; i < N - 1; i++) {
            long temp = road[i];
            int count = 0;
            for (int j = i + 1; j < N - 1; j++) {
                if (gasStation[i] < gasStation[j]) {
                    count++;
                    temp += road[j];
                } else {
                    break;
                }
            }
            result += gasStation[i] * temp;
            i += count;
        }

        System.out.println(result);
    }
}