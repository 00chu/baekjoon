import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == 'c') {
                if ((str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
                    count++;
                    i++;
                } else {
                    count++;
                }
            } else if (str.charAt(i) == 'd' && i < str.length() - 1) {
                if (i < str.length() - 2 && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    count++;
                    i += 2;
                } else if (str.charAt(i + 1) == '-') {
                    count++;
                    i++;
                } else {
                    count++;
                }
            } else if (i < str.length() - 1 && (str.charAt(i) == 'l' || str.charAt(i) == 'n')) {
                if (str.charAt(i + 1) == 'j') {
                    count++;
                    i++;
                } else {
                    count++;
                }
            } else if (i < str.length() - 1 && (str.charAt(i) == 's' || str.charAt(i) == 'z')) {
                if (str.charAt(i + 1) == '=') {
                    count++;
                    i++;
                } else {
                    count++;
                }
            } else {
                count++;
            }
        }

        System.out.println(count);
    }
}