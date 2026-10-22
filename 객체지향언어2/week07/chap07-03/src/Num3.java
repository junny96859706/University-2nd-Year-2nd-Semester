import java.util.HashMap;
import java.util.Scanner;

public class Num3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		System.out.println("주식 종목과 주가를 입력하세요(예: 삼송전자 75000)");
		while(true) {
			System.out.print("종목, 주가>>");
			String name = scanner.next();
			if("그만".equals(name))
				break;
			Integer score = scanner.nextInt();
			h.put(name, score);
		}
		
		System.out.println("주가를 검색합니다.");
		while(true) {
			System.out.print("종목>>");
			String name = scanner.next();
			if("그만".equals(name))
				break;
			Integer score = h.get(name);
			if(score == null) {
				System.out.println(name + "은 없는 종목입니다.");
				continue;
			}
			System.out.println(name + "의 주가는 " + score + "원");
		}
		
		
		scanner.close();
	}

}
