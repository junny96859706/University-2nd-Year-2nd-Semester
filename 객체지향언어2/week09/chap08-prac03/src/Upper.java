import java.io.FileReader;
import java.io.IOException;
import java.io.Scanner;

public class Upper {
	public static void main(String[] args) { 
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			while((c = fin.read()) != -1) {
				c = Character.toUpperCase(c);
				System.out.print((char)c);
			}
			fin.close();
		}
		catch (IOException e) {
			System.out.println("system.ini파일을 열수 없습니다.");
		}

	}

}
