import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int[] wanho = scores[0];
        int wanhoScore = wanho[0] + wanho[1];
        int maxScore = 0;

        Arrays.sort(scores, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return 0;
        });

        for (int i = 0; i < scores.length; i++) {
            if (maxScore <= scores[i][1]) {
                maxScore = scores[i][1];
                if (scores[i][0] + scores[i][1] > wanhoScore) {
                    answer++;
                }
            } else {
                if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) {
                    answer = -1;
                    break;
                }
            }
        }
        
        if(answer!=-1){
            answer++;
        }
        
        return answer;
    }
}