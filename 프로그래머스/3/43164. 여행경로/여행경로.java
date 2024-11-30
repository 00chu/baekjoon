import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> route;

    public static void dfs(String depart, String arrive, String[][] tickets, int count) {
        if (count == tickets.length) {
            route.add(arrive);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (depart.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], arrive + " " + tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];
        route = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(route);

        answer = route.get(0).split(" ");
        
        return answer;
    }
}