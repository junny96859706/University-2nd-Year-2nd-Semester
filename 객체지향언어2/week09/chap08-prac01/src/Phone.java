import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Phone {

	public static void main(String[] args) {
		FileWriter fr = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("전화번호 입력 프로그램입니다.");
		
		try {
			fr = new FileWriter("c:\\temp\\phone.txt");
			while(true) {
				System.out.print("이름 전화번호 >> ");
				String phone = scanner.nextLine();
				if("그만".equals(phone))
					break;
				fr.write(phone);
				fr.write("\r\n");
			}
			fr.close();
		}
		catch (IOException e) {
			System.out.println("Phone.txt 파일을 열수 없습니다.");
		}
		
		System.out.println("c:\\temp\\phone.txt에 저장하였습니다.");
		scanner.close();
	}

}
