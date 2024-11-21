class Solution {
    public int solution(int[][] board, int[][] skill) {
        
       int answer = 0;

        int[][] result = new int[board.length+1][board[0].length+1];

        for (int i = 0; i < skill.length; i++) {
            int[] temp = skill[i];

            if (temp[0] == 1) {
                temp[5] = -temp[5];
            }

            result[temp[1]][temp[2]] += temp[5];
            result[temp[1]][temp[4]+1] -= temp[5];
            result[temp[3]+1][temp[2]] -= temp[5];
            result[temp[3]+1][temp[4]+1] += temp[5];
        }

        int[][] sum = new int[board.length+1][board[0].length+1];

        for (int i = 0; i <= board.length; i++) { //가로로
            sum[i][0] = result[i][0];
            for (int j = 1; j <= board[0].length; j++) {
                sum[i][j] = result[i][j] + sum[i][j - 1];
            }
        }

        for (int i = 0; i <= board[0].length; i++) { //세로로
            for (int j = 1; j <= board.length; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
        
        for (int i = 0; i < board.length; i++) { //최종 계산
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}