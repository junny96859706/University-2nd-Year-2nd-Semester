import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class ScannerEx {
	public static void main(String[] args) {
		Scanner fscanner = null;
		int lineNumber = 1;
		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
		try {
			fscanner = new Scanner(new FileReader("c:\\windows\\system.ini"));
			while(fscanner.hasNext()) {
				String line = fscanner.nextLine();
				System.out.printf("%4d: ", lineNumber);
				System.out.println(line);
				lineNumber++;
			}
			
			fscanner.close();
		}
		catch (IOException e) {
			System.out.println("해당 파일을 열수 없습니다.");
		}
		
	}
}
