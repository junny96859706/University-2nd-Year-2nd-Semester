import java.util.Scanner;

public class num3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		
		System.out.println("제출자: 이지형\n");
		
		while(true) {
			System.out.println("양의 정수 입력>>");
			num = scanner.nextInt();
			if(num>0)
				break;
		}
		
		for(int i=num; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
}
