import java.util.Vector;
import java.util.Iterator;
import java.util.Scanner;

public class Num1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		
		System.out.print("정수입력(-1이면 입력 끝)>>");
		while(true) {
			int n = scanner.nextInt();
			if(n == -1)
				break;
			v.add(n);
		}
		
		Iterator<Integer> it = v.iterator();
		int min = it.next();
		while(it.hasNext()) {
			int temp = it.next();
			if(min > temp)
				min = temp;
		}
		
		System.out.print("제일 작은 수는 " + min);
		
		scanner.close();
	}

}
