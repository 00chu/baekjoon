class Solution {
    public static boolean flag;

    public static void calculate(String binary, int s, int e, int size, int count) {
        int mid = size / 2;

        if (mid == 0) {
            return;
        }

        if (binary.charAt(s + mid) == '0') {
            if (binary.charAt((s + mid - (int) Math.pow(2, count))) == '1'
                    || binary.charAt((s + mid + (int) Math.pow(2, count))) == '1') {
                flag = false;
                return;
            }
        }

        calculate(binary, s, e - 1 - mid, mid, count - 1);
        calculate(binary, s + 1 + mid, e, mid, count - 1);
    }
    
    public int[] solution(long[] numbers) {
      int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            flag = true;

            int num = 0;
            String binary = Long.toBinaryString(numbers[i]);
            int length = binary.length();
            int count = 0;

            for (int j = 0; true; j++) {
                num += (int) Math.pow(2, j);
                count = j;
                if (length == num) {
                    break;
                }
                if (num - Math.pow(2, j) < length && length < num) {
                    for (int k = 0; k < num - length; k++) {
                        binary = "0".concat(binary);
                    }
                    break;
                }
            }

            calculate(binary, 0, binary.length() - 1, binary.length(), count - 1);

            if (flag) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}