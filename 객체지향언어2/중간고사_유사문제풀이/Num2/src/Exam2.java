import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("$1=1200원입니다. 달러를 입력하세요>>");
		int money = scanner.nextInt();
		System.out.println("$" + money + "는 " + money*1200 + "원입니다.");

	}

}
