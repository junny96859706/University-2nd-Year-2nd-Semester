import java.util.Scanner;
import java.util.InputMismatchException;

public class Num17 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String coffee[] = {"핫아메리카노","아이스아메리카노","카푸치노","라떼"};
		int price[] = {3000,3500,4000,5000};
		
		System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");
		
		while(true) {
			System.out.print("주문>>");
			String name = "";
			int num = 0;
			int index = -1;
			
			try {
				name = scanner.next();
				if(("그만").equals(name))
					break;
				num = scanner.nextInt();
				
				if(num < 0) {
					System.out.println("잔수는 양수여야 합니다.");
					continue;
				}
				
				for(int i=0; i<coffee.length; i++) {
					if(coffee[i].equals(name))
						index = i;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("잔 수는 양의 정수로 입력해주세요!!!");
				scanner.nextLine();
				continue;
			}
			
			if(index == -1) {
				System.out.println(name + "은 없는 메뉴입니다.");
				continue;
			}
			else {
				System.out.println("가격은 " + (price[index]*num) + "원입니다.");
			}
			
			
		}
		
		
		scanner.close();
	}

}
