import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        
        boolean[] result = new boolean[n];
        Stack<Integer> deleted = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].equals("C")) {
                deleted.push(k);
                if (k == n - deleted.size()) {
                    k--;
                }
            } else if (cmd[i].equals("Z")) {
                if(deleted.pop()<=k){
                    k++;
                }
            } else {
                String[] order = cmd[i].split(" ");

                if (order[0].equals("D")) {
                    k += Integer.parseInt(order[1]);
                } else {
                    k -= Integer.parseInt(order[1]);
                }
            }
        }

        for (int i = 0; i < n - deleted.size(); i++) {
            sb.append("O");
        }
        while(!deleted.isEmpty()){
            sb.insert(Integer.parseInt(String.valueOf(deleted.pop())), "X");
        }

        answer = sb.toString();
        
        return answer;
    }
}