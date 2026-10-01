import java.util.Scanner;

public class Num3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("**** 자바분식입니다. 주문하면 금액을 알려드립니다. ****");
		
		System.out.print("떡볶이 몇 인분>>");
		int food1_Num = scanner.nextInt();
		
		System.out.print("김말이 몇 인분>>");
		int food2_Num = scanner.nextInt();
		
		System.out.print("쫄면 몇 인분>>");
		int food3_Num = scanner.nextInt();
		
		int total_Money = (2000*food1_Num)+(1000*food2_Num)+(3000*food3_Num);
		
		System.out.print("전체 금액은 " + total_Money + "원입니다.");
		
		scanner.close();
	}
}
