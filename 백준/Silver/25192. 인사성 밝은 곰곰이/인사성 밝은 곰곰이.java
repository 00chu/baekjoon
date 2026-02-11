import java.io.*;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> nickname = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();

            if (Objects.equals("ENTER", temp)) {
                count += nickname.size();
                nickname.clear();
            } else {
                nickname.add(temp);
            }
        }

        count += nickname.size(); //마지막 더해주기

        System.out.println(count);
    }
}