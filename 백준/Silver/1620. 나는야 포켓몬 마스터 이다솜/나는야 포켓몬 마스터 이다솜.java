import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> list1 = new HashMap<Integer, String>();
        HashMap<String, Integer> list2 = new HashMap<String, Integer>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            list1.put(i, name);
            list2.put(name, i);
        }

        for (int i = 1; i <= M; i++){
            String find = br.readLine();
            if(Character.isDigit(find.charAt(0))){
                sb.append(list1.get(Integer.parseInt(find))).append("\n");
            }
            else{
                sb.append(list2.get(find)).append("\n");
            }
        }

        System.out.println(sb);
    }
}