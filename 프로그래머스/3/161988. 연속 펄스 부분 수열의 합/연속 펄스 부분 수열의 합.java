class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[] s1 = new long[sequence.length];
        long[] s2 = new long[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            s1[i] = sequence[i];
            s2[i] = -sequence[i];
        }

        for (int i = 1; i < sequence.length; i++) {
            s1[i] = Math.max(sequence[i], s2[i - 1] +s1[i]);
            s2[i] = Math.max(-sequence[i], s1[i - 1] +s2[i]);
        }

        for (int i = 0; i < sequence.length; i++) {
            answer = Math.max(answer, s1[i]);
            answer = Math.max(answer, s2[i]);
        }
        
        return answer;
    }
}