import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Long> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine()); //테스트 케이스

        arr.add(0L);
        arr.add(1L);
        for (int i = 1; i < n; i++) {
            Long sum = arr.get(arr.size() - 2) + arr.get(arr.size() - 1);
            arr.add(sum);
        }

        if (n == 0) {
            System.out.println("0");
        } else if (n == 1) {
            System.out.println("1");
        } else {
            System.out.println(arr.get(arr.size() - 1));
        }
    }
}