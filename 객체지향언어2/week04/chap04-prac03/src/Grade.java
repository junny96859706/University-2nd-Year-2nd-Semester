import java.util.Scanner;

public class Grade {
	String name;
	int java,web,os;
	
	Grade(String name,int java,int web,int os){
		this.name = name;
		this.java = java;
		this.web = web;
		this.os = os;
	}
	
	String getName() {
		return name;
	}
	
	double getAverage() {
		double avg = (double)(java+web+os)/3;
		return avg;
	}
	
	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제순으로 점수 입력>>");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		
		Grade st = new Grade(name,java,web,os); //한명의 점수 객체 생성
		System.out.print(st.getName() + "의 평균은" + st.getAverage());
		
		scanner.close();
	}
}
