import java.util.Scanner;
import java.util.InputMismatchException;

public class num15 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int num1=0, num2=0;
		
		while(true) {
			
			System.out.print("곱하고자 하는 정수 2개 입력>>");
			try {
				num1 = scanner.nextInt();
				num2 = scanner.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요!!!");
				scanner.nextLine(); //버퍼 한줄 전체 비우기!!!!
				continue;
			}
		}
		System.out.println(num1 + "x" +num2 + "=" + (num1*num2));
		
		scanner.close();
	}
}
