import java.util.Scanner;

public class Num2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year,month,day;
		int tempNum;
		
		System.out.print("생일을 입력 하세요>>");
		tempNum = scanner.nextInt();
		
		year = tempNum / 10000;
		int rest = tempNum % 10000;
		
		month = rest / 100;
		day = rest % 100;
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		scanner.close();
	}
}
