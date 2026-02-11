import java.util.Scanner;
public class Test {
	static long sum(int[] a) {
		long result = 0;
		for(int i = 0; i < a.length; i++) {
			result = result + a[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int newa[] = new int[n];
		
		for(int i = 0; i < newa.length; i++) {
			newa[i] = scanner.nextInt();
		}
		System.out.println(sum(newa));
	}

}
