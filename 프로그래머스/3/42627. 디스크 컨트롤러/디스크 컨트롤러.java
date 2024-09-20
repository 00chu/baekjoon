import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class Job {
        int number;
        int time;

        public Job(int number, int time) {
            this.number = number;
            this.time = time;
        }
    }
class Solution {
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int index = 0;
        int end = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Job> request = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));


        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= end) {
                request.add(new Job(jobs[index][0], jobs[index][1]));
                index++;
            }

            if (request.isEmpty()) {
                end = jobs[index][0];
            } else {
                Job temp = request.poll();
                answer += end - temp.number + temp.time;
                end += temp.time;
                count++;
            }

        }
        
        return answer / jobs.length;
    }
}