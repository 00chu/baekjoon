import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            boolean result = true;

            int n = Integer.parseInt(br.readLine());

            ArrayList<String> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (list.get(j).charAt(0) == list.get(k).charAt(0)) {
                        if(list.get(j).length() <= list.get(k).length()){
                            if (Objects.equals(list.get(j), list.get(k).substring(0, list.get(j).length()))) {
                                result = false;
                                break;
                            }
                        }else{
                            if (Objects.equals(list.get(k), list.get(j).substring(0, list.get(k).length()))) {
                                result = false;
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }

            if (result) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}