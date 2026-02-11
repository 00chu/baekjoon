import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hash = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            hash.put(st.nextToken(), st.nextToken());
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            sb.append(hash.get(s)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}