import java.util.Scanner;

public class Exam6 {
	private String name; // 학생 이름
	private int java, web, os; // 과목 점수
	
	public Exam6(String name, int java, int web, int os) { // 생성자
		this.name = name;
		this.java = java;
		this.web = web;
		this.os = os;
	}
	
	public String getName() { return name; }
	
	public int getAverage() {
		//본인이 작성하라
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		Exam6 st = new Exam6(name, java, web, os); // 한 명의 점수 객체 생성
		System.out.print(st.getName() + "의 평균은 " + st.getAverage());
		scanner.close();
	}

}
