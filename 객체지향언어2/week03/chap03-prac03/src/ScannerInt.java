//예외처리까지 연습해보고 싶어서 코드 추가함!!!!!!

import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerInt { //3장 예제3번

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		
		while(true) {
			System.out.print("양의 정수 입력>>");
			try {
				num = scanner.nextInt(); //여기서 문자를 입력하면 오류발생!!!
				if(num > 0)
					break;
			}
			catch(InputMismatchException e) {
				System.out.println("경고: 정수만 입력해야합니다");
				scanner.next(); //핵심:잘못입력된 문자데이터가 스캐너버퍼에 남아있으므로 버처를 비움
			}
		}
		
		for(int i=num; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
