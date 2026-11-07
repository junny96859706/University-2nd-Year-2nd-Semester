import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fin = null;
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			//문자 입력 스트림 생성
			int c;
			while((c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			
			fin.close();
		}
		catch (IOException e) {
			System.out.println("입출력오류");
		}
		
	}
}
