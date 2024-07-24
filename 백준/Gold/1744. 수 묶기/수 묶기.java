import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        long result = 0;

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        while (!arr.isEmpty()) {
            if (arr.size() == 1) {
                result += arr.get(0);
                arr.remove(0);
            } else {
                if (arr.get(0) < 0) {
                    if (arr.get(1) < 0) {
                        result += arr.get(0) * arr.get(1);
                        arr.remove(0);
                        arr.remove(0);
                    } else if (arr.contains(0)) {
                        result += arr.get(0) * arr.get(arr.indexOf(0));
                        arr.remove(0);
                        arr.remove(arr.indexOf(0));
                    } else {
                        result += arr.get(0);
                        arr.remove(0);
                    }
                } else if (arr.get(arr.size() - 1) * arr.get(arr.size() - 2) > arr.get(arr.size() - 1) + arr.get(arr.size() - 2)) {
                    result += arr.get(arr.size() - 1) * arr.get(arr.size() - 2);
                    arr.remove(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                } else {
                    result += arr.get(arr.size() - 1) + arr.get(arr.size() - 2);
                    arr.remove(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                }
            }
        }

        System.out.println(result);
    }
}