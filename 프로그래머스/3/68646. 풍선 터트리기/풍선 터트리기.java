class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int minL = a[0];

        int[] minR = new int[a.length];
        minR[a.length - 1] = a[a.length - 1];

        for (int i = a.length - 2; i > 0; i--) {
            minR[i] = Math.min(minR[i + 1], a[i]);
        }

        if (a.length > 2) {
            for (int i = 0; i < a.length; i++) {
                if (!(minL<a[i]&&minR[i]<a[i])){
                    answer++;
                    minL = Math.min(minL, a[i]);
                }
            }
        } else {
            answer = a.length;
        }
        
        return answer;
    }
}