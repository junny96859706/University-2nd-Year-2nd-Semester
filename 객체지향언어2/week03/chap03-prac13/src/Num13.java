import java.util.Scanner;

public class Num13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String course [] = {"C","C++","python","Java","HTML5"};
		String grade [] = {"A","B+","B","A+","D"};
		
		while(true) {
			System.out.print("과목>>");
			String courseName = scanner.next();
			int tempIndex = -1;
			
			if(courseName.equalsIgnoreCase("그만")) 
				break;
				
			for(int i=0; i<course.length; i++) {
				if(course[i].equals(courseName))
					tempIndex = i;
			}
			
			if(tempIndex != -1)
				System.out.println(course[tempIndex] + "의 학점은 " + grade[tempIndex]);
			else
				System.out.println(courseName + "은 없는 과목입니다.");
			
		
		}
		
		
		scanner.close();
	}

}
