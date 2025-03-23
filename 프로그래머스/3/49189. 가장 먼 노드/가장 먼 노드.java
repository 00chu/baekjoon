import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int[] result = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < graph.get(num).size(); i++) {
                if (!visited[graph.get(num).get(i)]) {
                    queue.offer(graph.get(num).get(i));
                    visited[graph.get(num).get(i)] = true;
                    result[graph.get(num).get(i)] = result[num] + 1;
                }
            }
        }

        Arrays.sort(result);
        for (int i = result.length-1; i>0; i--) {
            if( result[result.length-1]==result[i]){
                answer++;
            }
        }
        
        return answer;
    }
}