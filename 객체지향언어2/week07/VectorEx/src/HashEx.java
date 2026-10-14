import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashEx {

	public static void main(String[] args) {
		HashMap<String,String> dic = new HashMap<String,String>();
		dic.put("baby", "아기");
		dic.put("love","사랑");
		dic.put("apple","사과");
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("영단어>>");
			String word = scanner.next();
			if("exit".equals(word))
				break;
			String kor = dic.get(word);
			if(kor == null)
				System.out.println(word + "는 없는 단어입니다.");
			else
				System.out.println(word + ":" + kor);
		}
		
		System.out.println("사전에 들어있는 모든 단어 출력");
		Set<String> keys = dic.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String eng = it.next();
			String kor = dic.get(eng);
			System.out.println(eng + ":" + kor);
		}
		
		System.out.println("종료합니다....");
		
	}

}
