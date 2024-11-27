class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if (sticker.length == 1) {
            return sticker[0];
        }

        int[] temp = new int[sticker.length];

        temp[0] += sticker[0];
        temp[1] += sticker[0];
        for (int i = 2; i < sticker.length; i += 1) {
            temp[i] = Math.max(temp[i - 2] + sticker[i], temp[i - 1]);
        }

        answer = temp[sticker.length - 2];

        temp[0] = 0;
        temp[1] = sticker[1];
        for (int i = 2; i < sticker.length; i += 1) {
            temp[i] = Math.max(temp[i - 2] + sticker[i], temp[i - 1]);
        }

        answer = Math.max(answer, temp[sticker.length - 1]);

        return answer;
    }
}