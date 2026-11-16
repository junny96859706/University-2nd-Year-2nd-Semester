import java.io.File;

public class Num09 {

	public static void main(String[] args) {
		System.out.println("c:\\temp디렉터리의 .txt파일을 모두 삭제합니다...");
		File f = new File("c:\\temp");
		File[] subfiles = f.listFiles();
		int deleteNum = 0;
		
		for(int i=0; i<subfiles.length;i++) {
			//현재 항목이 일반 파일이 아니라 디렉터리(폴더)인 경우,
			//삭제 대상에서 제외하고 다음 반복으로 건너뜀
			if (!subfiles[i].isFile()) {
				continue;
			}
			String fileName = subfiles[i].getName();
			int index = fileName.lastIndexOf(".txt");
			
			if((index != -1) && (index == fileName.length() - 4)) {
				// 1) ".txt"가 존재하고(index != -1)
				// 2) 그 위치가 정확히 뒤에서 4글자 시작점과 같을 때
				System.out.println(subfiles[i].getPath() + " 삭제");
				subfiles[i].delete();
				deleteNum++;
			}
		}
		
		System.out.println("총 " + deleteNum + "개의 .txt 파일을 삭제하였습니다.");
		
	}

}
