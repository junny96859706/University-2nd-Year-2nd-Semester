import java.util.Scanner;
public class Main {
	public static void main(String [] args) {
		Exam8 c = new Exam8();
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 입력하세요>>");
		int first = scanner.nextInt();
		System.out.print("입력배열: "+first+",3,4\n");
		System.out.println("평균: " + c.average(new int [] { first,3,4 }));
		System.out.print("\n입력배열: "+first+",1\n");
		System.out.println("평균: " + c.average(new int [] { first,1 }));
		scanner.close();
	}
}