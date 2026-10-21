import java.util.Scanner;

public class Exam3 {
	public static void main (String args[])  {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("점 (x, y)의 좌표 입력>>");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if(x>10 && x<200 && y>10 && y<300)
			System.out.print("(" + x + "," + y + ")" + "는 사각형 안에 있습니다.");
		else if(x < 10 || x>200 || y<10 || y>300)
			System.out.print("(" + x + "," + y + ")" + "는 사각형 밖에 있습니다.");
		else
			System.out.print("(" + x + "," + y + ")" + "는 사각형 선상에 있습니다.");
		
		
		scanner.close();
	}
}
