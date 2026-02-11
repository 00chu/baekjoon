import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        double result = 0, maxScore = 0;

        num = sc.nextInt();

        int score[];
        score = new int[num];

        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
            if (score[i] > maxScore) {
                maxScore = score[i];
            }
        }

        for (int i = 0; i < num; i++) {
            result += (score[i] / maxScore) * 100;
        }

        System.out.println(result/num);
    }
}