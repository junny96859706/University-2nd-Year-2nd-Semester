public class Main {

	public static void main(String[] args) {
		int [] array1 = { 2,3 };
		int [] array2 = { 3, 6, -1, 100, 77 };
		int [] array3 = Exam9.concat(array1, array2);
		
		System.out.println("제출자: 이지형");
		System.out.println();
		Exam9.print(array3);
	}

}