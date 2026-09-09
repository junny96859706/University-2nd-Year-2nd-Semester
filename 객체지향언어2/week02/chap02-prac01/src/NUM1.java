import java.util.Scanner;

public class NUM1 {
	public static void main(String[] args) {
		System.out.println("제출자:이지형");
		System.out.println();
		
		System.out.print("1$=1200원입니다. 달러를 입력하세요>>");
		Scanner scanner = new Scanner(System.in);
		int AmMoney = scanner.nextInt();
		int KorMoney = AmMoney*1200;
		System.out.println("$" + AmMoney + "는 " + KorMoney + "원입니다.");
		
		scanner.close();
	}
}
