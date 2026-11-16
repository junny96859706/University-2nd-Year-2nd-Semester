import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Num11 {

	public static void main(String[] args) {
		Scanner fscanner = null;
		Vector<String> wordVector = new Vector<String>();
		
		try {
			fscanner = new Scanner(new FileReader("words.txt"));
			while(fscanner.hasNext()){
				String oneLine = fscanner.nextLine();
				wordVector.add(oneLine);
			}
			//내부에 연결된 FileReader까지 자동으로 함께 닫힌다.
			fscanner.close();
		}
		catch (IOException e) {
			System.out.println("해당파일을 열수 없어 종료합니다.");
			return; 
			//파일을 못열었을때 실제 프로그램 종료처리!!
		}
		
		System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다...");
		Scanner scanner = new Scanner(System.in);
		String searchWord;
		int find = 0;
		
		while(true) {
			find = 0;
			System.out.print("단어>>");
			searchWord = scanner.next();
			if("그만".equals(searchWord)) {
				System.out.println("종료합니다...");
				break;
			}
			for(int i=0; i<wordVector.size();i++) {
				String word = wordVector.get(i);
				//비교할문자열로 정확히 시작하면 true, 그렇지 않으면 false를 반환
				//boolean result = 대상문자열.startsWith(비교할문자열);
				if(word.startsWith(searchWord)) {
					System.out.println(word);
					find++;
				}
			}
			if(find == 0)
				System.out.println("발견할 수 없음.");
		}
		
		scanner.close();
	}
}
