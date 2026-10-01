import java.util.Scanner;

public class Num5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int student1;
		int student2;
		
		System.out.print("student1>>");
		String name1 = scanner.next();
		int late = scanner.nextInt();
		int absent = scanner.nextInt();
		student1 = ((3*late)+(8*absent));
		
		System.out.print("student2>>");
		String name2 = scanner.next();
		late = scanner.nextInt();
		absent = scanner.nextInt();
		student2 = ((3*late)+(8*absent));
		
		System.out.println(name1 + "의 감점은" + student1 + ", " + name2 + "의 감점은 " + student2);
		
		if(student1 < student2) {
			System.out.println(name1 + "의 출석 점수가 더 높음. " + name1 + " 출석 점수는 " + (100 - student1));
		}
		else if(student1 > student2) {
			System.out.println(name2 + "의 출석 점수가 더 높음. " + name2 + " 출석 점수는 " + (100 - student2));
		}
		else {
			System.out.println("점수 동일");
		}
		

	}

}
