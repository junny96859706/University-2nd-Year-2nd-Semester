import java.util.Scanner;
import java.util.InputMismatchException;

public class Num5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int []intArray = new int[10];
		System.out.print("양의 정수 10개 입력>>");
		
		for(int i=0;i<intArray.length;i++) {
			try {
				int num = scanner.nextInt(); //여기서 문자를 입력하면 오류발생!!!
				
				if(num <= 0) {
					System.out.println("양의정수만 입력할수 있습니다. 다시입력!");
					i--; //입력실패했으므로 인덱스 되돌림
					continue; //아래 저장 코드를 건너뛰고 다음 순회(증감식 i++)로 이동
				}
				
				intArray[i] = num;
				
			}
			catch(InputMismatchException e){
				System.out.println("문자열을 입력할수없습니다. 정수를 다시 입력!");
				scanner.next();
				i--;
			}
		}
		
		System.out.print("3의 배수는...");
		
		for(int i=0;i<intArray.length;i++) {
			if(intArray[i]%3 == 0)
				System.out.print(intArray[i] + " ");
		}
		
		scanner.close();
	}

}
