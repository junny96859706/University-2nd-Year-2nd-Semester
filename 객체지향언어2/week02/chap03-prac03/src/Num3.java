import java.util.Scanner;


public class Num3 {
	public static void main(System[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int Tteokbokki = 2000;
		int Gimmari = 1000;
		int Jjolmyeon = 3000;
		
		System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
		System.out.print("떡볶이 몇 인분>>");
		int menu1 = scanner.nextInt() * Tteokbokki;
		System.out.print("김말이 몇 인분>>");
		int menu2 = scanner.nextInt() * Gimmari;
		System.out.print("쫄면 몇 인분>>");
		int menu3 = scanner.nextInt() * Jjolmyeon;
		
		int totalPrice = menu1 + menu2 + menu3;
		
		System.out.print("전체금액은 " + totalPrice + "원입니다." );
		
		
		scanner.close();
	}
}
