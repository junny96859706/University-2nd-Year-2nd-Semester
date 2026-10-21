import java.util.Scanner;

public class Exam10 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n;
		while(true) {
			System.out.print("양의 정수 입력>>");
			n = scanner.nextInt();
			if(n > 0)
				break;
		}
			
		for(int i=0; i<n; i++) { // n번 루프
			for(int j=i;j<n;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		scanner.close();
	}
}