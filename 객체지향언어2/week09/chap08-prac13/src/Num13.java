import java.io.File;
import java.util.Scanner;

public class Num13 {
	public static void printFile(File dir) {
		if(dir.isDirectory())
			System.out.print("dir");
		else
			System.out.print("file");
		
		System.out.print("\t" + dir.length() + "바이트");
		System.out.println("\t" + dir.getName());
	}
	
	
	public static void listDirectory(File dir) {
		System.out.println("   [" + dir.getPath() + "]");
		
		File[] listfiles = dir.listFiles();
		if (listfiles == null) { // 접근 권한이 없는 시스템 폴더 방어
			System.out.println("접근할 수 없는 디렉터리입니다.");
			return;
		}
		
		if(listfiles.length > 10) {
			for(int i=0; i<4; i++) {
				printFile(listfiles[i]);
			}
			for(int i = 0;i<28; i++) {
				System.out.print(". ");
			}
			System.out.print("생략하였습니다. ");
			for(int i = 0;i<28; i++) {
				System.out.print(". ");
			}
			System.out.println();
			for(int i=6; i>0; i--) {
				printFile(listfiles[listfiles.length - i]);
			}
		}
		else {
			for(int i=0; i<listfiles.length;i++) {
				printFile(listfiles[i]);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file = new File("c:\\");
		String order;
		
		System.out.println("***** 파일 탐색기입니다. *****");
		listDirectory(file);
		
		while(true) {
			System.out.print(">>");
			order = scanner.nextLine();
			if("그만".equals(order))
				break;
			else if("..".equals(order)) {
				String parentPath = file.getParent();
				if(parentPath != null) {
					file = new File(parentPath);
					listDirectory(file);
				}
				else
					System.out.println("최상위 경로입니다.");
			}
			else {
				File nextDir = new File(file, order); // 부모 File과 하위 이름을 안전하게 결합
				if(nextDir.exists() && nextDir.isDirectory()) { // 폴더일 때만 이동
					file = nextDir;
					listDirectory(file);
				}
				else {
					System.out.println("존재하지 않거나 디렉터리가 아닙니다.");
				}
			}
		}
		System.out.println("파일 탐색기를 종료합니다.");
		scanner.close();	
	}

}
