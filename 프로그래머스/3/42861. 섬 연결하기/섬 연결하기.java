import java.util.ArrayList;
import java.util.Comparator;

class Bridge {
    int start;
    int end;
    int cost;

    public Bridge(int start, int end, int cost) {
       this.start = start;
       this.end = end;
       this.cost = cost;
    }

    public int getCost() {
       return this.cost;
     }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];

        ArrayList<Bridge> list = new ArrayList<>();

        for (int i = 0; i < costs.length; i++) {
            list.add(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }

        list.sort(Comparator.comparing(Bridge::getCost));

        Bridge temp = list.get(0);

        visited[temp.start] = true;
        visited[temp.end] = true;
        answer += temp.cost;

        list.remove(0);

        boolean flag = true;

        int num = 0;
        int visitedNum = 2;

        while (flag) {
            if(list.isEmpty()||visitedNum==n){
                flag = false;
                break;
            }
            
            temp = list.get(num);
            if ((visited[temp.start] && !visited[temp.end])
                    || (!visited[temp.start] && visited[temp.end])) {
                visited[temp.start] = true;
                visited[temp.end] = true;
                visitedNum+=1;
                answer += temp.cost;

                list.remove(num);
                num = 0;
            } else {
                num++;
            }
        }
        
        return answer;
    }
}