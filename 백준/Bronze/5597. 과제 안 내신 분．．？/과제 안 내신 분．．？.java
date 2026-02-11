import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[31];
		int[] num = new int[2];
		int j = 0;
		
		for(int i = 0; i < 28; i++) {
			int order = scanner.nextInt();
			arr[order] = order;
		}
		
		for(int i = 1; i < 31; i++) {
			if(arr[i] != i) {
				num[j] = i;
				j++;
			}
		}
		
		System.out.println(num[0]);
		System.out.println(num[1]);
	}
}