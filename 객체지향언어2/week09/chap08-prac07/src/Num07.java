import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Num07 {

	public static void main(String[] args) {
		System.out.println("a.jpg를 b.jpg로 복사합니다.");
		System.out.println("10%마다 *를 출력합니다.");
		
		File f = new File("a.jpg");
		long fileSize = f.length();
		long tenPerCent = fileSize / 10;
		long downLoading = 0;
		int c;
		long n = 1;
		
		FileInputStream fin = null;
		FileOutputStream fout = null;

		try {
			fin = new FileInputStream(f);
			fout = new FileOutputStream("b.jpg");	
			while((c = fin.read()) != -1) {
				fout.write(c);
				downLoading++;
				
				if(n <= 10 && downLoading >= (tenPerCent*n)) {
					System.out.print("*");
					n++;
				}
			}
			
			fin.close();
			fout.close();
		}
		catch (IOException e) {
			System.out.println("해당파일을 열수없습니다!.");
		}
	}

}
