import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Exam2 exam2 = new Exam2();
		
		System.out.print("$1=1200원입니다. 달러를 입력하세요>>");
		int dollar = scanner.nextInt();		
		int won = exam2.exchange(dollar);
		System.out.println("$" + dollar + "는 " + won + "원입니다.");
		scanner.close();
	}

}