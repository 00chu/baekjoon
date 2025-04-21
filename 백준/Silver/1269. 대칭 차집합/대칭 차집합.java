import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] AList = new int[A];
        int[] BList = new int[B];

        HashSet<Integer> AMap = new HashSet<>();
        HashSet<Integer> BMap = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int num = Integer.parseInt(st.nextToken());
            AMap.add(num);
            AList[i] = num;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());
            BMap.add(num);
            BList[i] = num;
        }

        int ACount = 0;
        int BCount = 0;

        for (int i = 0; i < A; i++) {
            if (!BMap.contains(AList[i])) {
                ACount++;
            }
        }
        for (int i = 0; i < B; i++) {
            if (!AMap.contains(BList[i])) {
                BCount++;
            }
        }

        System.out.println(ACount + BCount);
    }
}