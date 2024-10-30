import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        ArrayList<Integer> cctv = new ArrayList<>();

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        cctv.add(routes[0][1]);

        for (int i = 1; i < routes.length; i++) {
            if (cctv.get(cctv.size()-1) < routes[i][0] || cctv.get(cctv.size()-1) > routes[i][1]) {
                cctv.add(routes[i][1]);
            }
        }

        answer = cctv.size();
        
        return answer;
    }
}