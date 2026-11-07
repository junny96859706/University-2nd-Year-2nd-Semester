import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileReadHangulSuccess {
	public static void main(String []args) {
		
		InputStreamReader in = null;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("c:\\temp\\hangul.txt");
			in = new InputStreamReader(fin,"UTF-8"); //올바른 문자 집합 지정
			int c;
			
			System.out.println("인코딩 문자 집합은" + in.getEncoding());
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			
			fin.close();
			in.close();
		}
		catch (IOException e) {
			System.out.println("파일 열기 및 쓰기 오류발생");
		}
	}
}
