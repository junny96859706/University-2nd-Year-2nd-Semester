import java.util.Scanner;

public class Main { 
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("스택 용량>>");
		int cap = scanner.nextInt();
		Exam5 sStack = new Exam5(cap);
		
		while(true) {
			System.out.print("문자열 입력>>");
			String str = scanner.next();
			if(str.equals("그만"))
				break;
			
			if(sStack.insert(str) == false) {
				System.out.println("스택이 꽉 차서 " + str + " 저장 불가");
			}
		}

		System.out.print("스택에 저장된 문자열 팝 : ");
		while(true) {
			String str = sStack.delete();
			if(str == null) {
				break; // 스택이 비어 있음
			}
			System.out.print(str + " ");
		}
		System.out.println();
		scanner.close();
	}
	
}