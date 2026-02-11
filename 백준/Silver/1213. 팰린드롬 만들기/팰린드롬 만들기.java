import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");

        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            hashMap.put(str[i], hashMap.getOrDefault(str[i], 0) + 1);
            if (hashMap.get(str[i]) == 1) {
                arr.add(str[i]);
            }
        }

        int count = 0;
        String center = "";

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (hashMap.get(arr.get(i)) % 2 == 1) {
                count++;
                if (1 < count) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                center = arr.get(i);
            }
            for (int j = 0; j < hashMap.get(arr.get(i)) / 2; j++) {
                result.add(arr.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        if (str.length % 2 == 0) {
            Collections.sort(result);
            sb.append(String.join("",result));

            Collections.reverse(result);
            sb.append(String.join("",result));

            System.out.println(sb);
        } else {
            Collections.sort(result);
            sb.append(String.join("",result));

            sb.append(center);

            Collections.reverse(result);
            sb.append(String.join("",result));

            System.out.println(sb);
        }
    }
}