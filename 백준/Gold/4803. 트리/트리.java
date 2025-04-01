import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static int findSet(int num) {
        if (num == parent[num]) {
            return num;
        } else {
            return findSet(parent[num]);
        }
    }

    public static void union(int num1, int num2) {
        num1 = findSet(num1);
        num2 = findSet(num2);

        if(num2 < num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num1 == num2) {
            parent[num1] = 0;
        } else {
            parent[num2] = num1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        while (true) {
            count++;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int answer;

            if (n == 0 && m == 0) {
                break;
            } else if (m == 0) {
                answer = n;
            } else {
                parent = new int[n + 1];

                for (int i = 1; i < n + 1; i++) {
                    parent[i] = i;
                }

                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());

                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());

                    union(num1, num2);
                }

                Set<Integer> set = new HashSet<>();
                for (int i = 1; i < n + 1; i++) {
                    int temp = findSet(i);
                    if (temp > 0) {
                        set.add(temp);
                    }
                }
                answer = set.size();
            }

            if (answer == 0) {
                System.out.println("Case " + count + ": No trees.");
            } else if (answer == 1) {
                System.out.println("Case " + count + ": There is one tree.");
            } else {
                System.out.println("Case " + count + ": A forest of " + answer + " trees.");
            }
        }
    }
}