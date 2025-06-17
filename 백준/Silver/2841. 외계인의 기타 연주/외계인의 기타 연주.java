import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Stack<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new Stack<>());
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (list.get(num).isEmpty() || list.get(num).peek() < p) {
                count++;
                list.get(num).push(p);
            }else{
                while (!list.get(num).isEmpty()&&list.get(num).peek() > p){
                    count++;
                    list.get(num).pop();
                }
                if (list.get(num).isEmpty()||list.get(num).peek()!=p){
                    count++;
                    list.get(num).push(p);
                }
            }
        }

        System.out.println(count);
    }
}