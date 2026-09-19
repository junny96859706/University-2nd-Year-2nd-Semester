import java.util.Scanner;

public class num13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("제출자: 이지형\n");
		
		String course [] = {"C", "C++", "Python", "Java", "HTML5"}; 
		String grade [] = {"A", "B+", "B", "A+", "D"};
		
		while(true) {
			System.out.print("과목>>");
			String word = scanner.next();
			if(word.equals("그만"))
				break;
			
			boolean found = false;
			
			for(int i=0; i<course.length; i++) {
				if(course[i].equals(word)) {
					System.out.println(course[i] + " 학점은 " + grade[i]);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println(word + "는 없는 과목입니다.");
			}
			
		}
		
		scanner.close();
	}
}
