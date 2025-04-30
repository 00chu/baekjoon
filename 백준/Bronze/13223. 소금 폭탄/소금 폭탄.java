import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nowTime = Stream.of(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] saltTime = Stream.of(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        String[] resultTime = new String[3];

        int time = (saltTime[0] * 3600 + saltTime[1] * 60 + saltTime[2])
                - (nowTime[0] * 3600 + nowTime[1] * 60 + nowTime[2]);

        if (time < 0) {
            time += 24 * 3600;
        }

        if (time == 0) {
            System.out.println("24:00:00");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (time >= 3600) {
            int num = time / 3600;
            if (num < 10) {
                sb.append(0).append(num).append(":");
            } else {
                sb.append(num).append(":");
            }
            time %= 3600;
        }else {
            sb.append("00").append(":");
        }

        if (time >= 60) {
            int num = time / 60;
            if (num < 10) {
                sb.append(0).append(num).append(":");
            } else {
                sb.append(num).append(":");
            }
            time %= 60;
        } else {
            sb.append("00").append(":");
        }

        if (time < 10) {
            sb.append(0).append(time);
        } else {
            sb.append(time);
        }

        System.out.println(sb);
    }
}