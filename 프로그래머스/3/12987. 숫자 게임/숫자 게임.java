import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = B.length - 1; i >= 0; i--){
           for(int j = i; j >= 0; j--){
               if(B[i] > A[j] && A[j] != 0){
                   A[j] = 0;
                   answer++;
                   break;
               }
           }
        }
        
        return answer;
    }
}