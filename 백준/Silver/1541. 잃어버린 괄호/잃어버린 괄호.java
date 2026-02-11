import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+");
        br.close();

        boolean flag = true;
        int plusSum = 0;
        int minusSum = 0;
        int count = 0;

        String[] list = new String[50];

        while (st.hasMoreTokens()) {
            String[] temp = st.nextToken().split("-");
            if (temp.length == 1) {
                String s = temp[0];
                list[count++] = s;
            } else {
                for (int i = 0; i < temp.length; i++) {
                    if (i % 2 == 1) {
                        list[count++] = "-";
                    }
                    list[count++] = temp[i];
                }
            }
        }

        for (int i = 0; i < count; i++) {
            if (Objects.equals(list[i], "-")) {
                flag = false;
            } else {
                if (flag) {
                    plusSum += Integer.parseInt(list[i]);
                } else {
                    minusSum += Integer.parseInt(list[i]);
                    if (Objects.equals(list[i + 1], "-")) {
                        flag = true;
                    }
                }
            }
        }

        System.out.println(plusSum - minusSum);
    }
}