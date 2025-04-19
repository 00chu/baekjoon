import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines, Comparator.comparingInt(o -> o.start));

        ArrayList<Line> list = new ArrayList<>();

        list.add(lines[0]);

        for (int i = 1; i < N; i++) {
            if (lines[i].start <= list.get(list.size() - 1).end) {
                if (list.get(list.size() - 1).end < lines[i].end) {
                    list.get(list.size() - 1).end = lines[i].end;
                }
            } else {
                list.add(lines[i]);
            }
        }

        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).end - list.get(i).start;
        }

        System.out.println(result);
    }
}