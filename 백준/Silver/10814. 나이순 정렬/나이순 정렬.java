import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static class member {
        int age;
        String name;

        public member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<member> list = new ArrayList<member>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        list.sort(new Comparator<member>() {
            @Override
            public int compare(member o1, member o2) {
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).toString());
        }
    }
}