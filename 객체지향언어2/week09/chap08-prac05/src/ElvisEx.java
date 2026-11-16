import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ElvisEx {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		
		FileInputStream fin1 = null;
		FileInputStream fin2 = null;
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		String file1 = scanner.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요>>");
		String file2 = scanner.nextLine();
		
		int c,d;
		boolean isSame = true; //두파일이 같은지 여부를 저장할 플레그변수
		try {
			fin1 = new FileInputStream(file1);
			fin2 = new FileInputStream(file2);
			System.out.println(file1 + "와 " + file2 + "를 비교합니다.");
			
			while((c = fin1.read()) != -1) {
				d = fin2.read(); 
				if(c != d) {
					isSame = false;
					break;
				}
			}
			
			if(isSame && fin2.read() != -1) {
				isSame = false;
			}
			
			if(isSame)
				System.out.println("파일이 같습니다.");
			else
				System.out.println("파일이 다릅니다.");
			
			fin1.close();
			fin2.close();
		}
		catch (IOException e) {
			System.out.println("파일중 하나를 열수없습니다.");
		}
		
		scanner.close();
	}
}
