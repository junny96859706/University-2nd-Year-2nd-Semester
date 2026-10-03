import java.util.Scanner;
import java.util.InputMismatchException;

public class Num11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");
		int count = 0;
		int answer = 0;
		
		while(count != 3) {
			int num1 = (int)(Math.random()*9+1);
			int num2 = (int)(Math.random()*9+1);
			
			System.out.print(num1 + "x" + num2 + "=");
			try {
				answer = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("문자열을 잘못 입력하셨습니다. 다른문제 재출제!");
				scanner.next();
				continue;
			}
			
			if(answer == (num1*num2)) {
				System.out.println("정답입니다. 잘했습니다.");
			}
			else {
				count++;
				System.out.print(count + "번 틀렸습니다. ");
				if(count == 3)
					System.out.println("퀴즈 종료합니다.");
				else 
					System.out.println("분발하세요.");
			}
			
		}
		
		scanner.close();
	}

}
