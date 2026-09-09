import java.util.Scanner;

public class NUM9 {
	public static void main(String[] args) {
	System.out.println("제출자: 이지형\n");
	
	System.out.print("점 (x, y)의 좌표 입력>>");
	Scanner scanner = new Scanner(System.in);
	int X = scanner.nextInt();
	int Y = scanner.nextInt();
	
	if(X<10 || X>200 || Y<10 || Y>300) 
		System.out.println("(" + X + "," + Y + ")는 사각형 밖에 있습니다.");
	else if(X>10 && X<200 && Y>10 && Y<300)
		System.out.println("(" + X + "," + Y + ")는 사각형 안에 있습니다.");
	else
		System.out.println("(" + X + "," + Y + ")는 사각형 선 상에 있습니다.");
	
	scanner.close();
	
	}
}
