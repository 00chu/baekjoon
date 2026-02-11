import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate> {
    int x; // x좌표
    int y; // y좌표

    public Coordinate(int x, int y) { // 생성자
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (this.y != o.y) return this.y - o.y;
        else return this.x - o.x;
    }

    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> num = new ArrayList<Coordinate>(); // 인스턴스 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            num.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        br.close();

        Collections.sort(num);

        for (int i = 0; i < N; i++) {
            bw.write(num.get(i).toString() + "\n");
        }

        bw.flush();
        bw.close();
    }
}