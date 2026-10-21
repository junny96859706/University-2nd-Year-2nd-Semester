import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Exam4 exam4 = new Exam4();
		
		System.out.print("$1=1200원입니다. 달러를 입력하세요>>");
		int dollar = scanner.nextInt();		
		int won = exam4.convert(dollar);
		System.out.println("$" + dollar + "는 " + won + "원입니다.");
		scanner.close();
	}

}
