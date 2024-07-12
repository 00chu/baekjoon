import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            boolean isReversed = false;
            boolean flag = true;

            String[] order = br.readLine().split("");

            int length = Integer.parseInt(br.readLine());

            ArrayList<String> list = new ArrayList<>(List.of(br.readLine().split(",")));

            list.set(0, list.get(0).replace("[", ""));
            list.set(list.size() - 1, list.get(list.size() - 1).replace("]", ""));

            if (length == 0 && Objects.equals(order[0], "D")) {
                flag = false;
            } else {
                for (int j = 0; j < order.length; j++) {
                    if (Objects.equals(order[j], "R")) {
                        isReversed = !isReversed;
                    } else {
                        if (length == 0 || list.isEmpty()) {
                            flag = false;
                            break;
                        } else if (isReversed) {
                            list.remove(list.size() - 1);
                        } else {
                            list.remove(0);
                        }
                    }
                }
            }

            if (isReversed) {
                Collections.reverse(list);
            }
            if (flag) {
                sb.append("[");
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                    if (list.size() - 1 != j) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            } else {
                sb.append("error\n");
            }

        }

        br.close();

        System.out.println(sb);
    }
}