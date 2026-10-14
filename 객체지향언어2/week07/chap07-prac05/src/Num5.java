import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Num5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		
		System.out.println("제출자: 이지형");
		System.out.println();
		System.out.println(" ***마일리지 관리 프로그램입니다***");
		while(true) {
			System.out.print("이름과 마일리지>>");
			String name = scanner.next();
			if("그만".equals(name))
				break;
			int score = scanner.nextInt();
			
			if(h.containsKey(name)) {
				score +=  h.get(name);
			}
			
			h.put(name,score);
		}
		
		Set<String> keys = h.keySet();
		Iterator<String> it = keys.iterator();
		int highScore = 0;
		String highName = "";
		
		while(it.hasNext()){
			String key = it.next();
			Integer value = h.get(key);
			if(value > highScore) {
				highScore = value;
				highName = key;
			}
			System.out.print("(" + key + ":" + value + ")");	
		}
		
		System.out.println();
		System.out.println("가장 마일리지가 높은 고객은 " + highName + "입니다");
		System.out.println("프로그램을 종료합니다.");
		
		
		scanner.close();
	}

}
