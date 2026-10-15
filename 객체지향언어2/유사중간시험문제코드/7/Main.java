import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		Exam7 exam6 = new Exam7(name, java, web, os); // 한 명의 점수 객체 생성
		System.out.print(exam6.getName() + "의 평균은 " + exam6.getAverage());
		scanner.close();
	}

}
