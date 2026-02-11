import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sTime = 0;
        Queue<Integer> sQueue = new LinkedList<>();
        int jTime = 0;
        Queue<Integer> jQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());

            if (color == 'B') {
                if (sTime == 0 || time > sTime) {
                    sTime = time;
                }

                for (int j = 0; j < count; j++) {
                    sQueue.offer(sTime);
                    sTime += A;
                }
            } else {
                if (jTime == 0 || time > jTime) {
                    jTime = time;
                }

                for (int j = 0; j < count; j++) {
                    jQueue.offer(jTime);
                    jTime += B;
                }
            }
        }

        int sCount = sQueue.size();
        int jCount = jQueue.size();

        StringBuilder sSb = new StringBuilder();
        StringBuilder jSb = new StringBuilder();

        int count = 1;

        while (!sQueue.isEmpty() && !jQueue.isEmpty()) {
            if (sQueue.peek() <= jQueue.peek()) {
                sSb.append(count++).append(" ");
                sQueue.poll();
            } else {
                jSb.append(count++).append(" ");
                jQueue.poll();
            }
        }

        while (!sQueue.isEmpty()){
            sSb.append(count++).append(" ");
            sQueue.poll();
        }

        while (!jQueue.isEmpty()){
            jSb.append(count++).append(" ");
            jQueue.poll();
        }

        System.out.println(sCount);
        System.out.println(sSb);
        System.out.println(jCount);
        System.out.println(jSb);
    }
}