import java.util.LinkedList;
import java.util.Queue;

class Solution {
     public static int answer = 0;
     public static int bfs(int start, int[][] computers, boolean[] list) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);

        list[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 0; i < computers[index].length; i++) {
                int temp = computers[index][i];

                if (temp == 1 && !list[i]) {
                    list[i] = true;
                    queue.offer(i);
                }
            }
        }

        return answer++;
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] list = new boolean[n];
        boolean flag = true;

        while (flag) {
            int start;
            for (int i = 0; i < n; i++) {
                if (!list[i]) {
                    start = i;
                    bfs(start, computers, list);
                }
                if (list[i] && i == n - 1) {
                    flag = false;
                }
            }
        }
        
        return answer;
    }
}