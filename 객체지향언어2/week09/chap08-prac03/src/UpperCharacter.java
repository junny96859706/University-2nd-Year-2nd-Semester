import java.io.FileReader;
import java.io.IOException;

public class UpperCharacter {
    public static void main(String[] args) {
        // 과제 제출용 이름 표시 (필수 조건)
        System.out.println("제출자: 이지형");
        System.out.println(); // 한 줄 공백

        FileReader fin = null;
        try {
            // c:\windows\system.ini 파일 읽기
            fin = new FileReader("c:\\windows\\system.ini");
            int c;
            
            // 파일 끝(EOF, -1)을 만날 때까지 한 문자씩 읽기
            while ((c = fin.read()) != -1) {
                // 읽은 문자를 대문자로 변환하여 출력
                char ch = (char) c;
                ch = Character.toUpperCase(ch);
                System.out.print(ch);
            }
            
            fin.close();
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다.");
        }
    }
}