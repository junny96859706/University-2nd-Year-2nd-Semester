public class Main {

	public static void main(String[] args) {
		int [] array1 = { 1, 5, 7, 9 };
		int [] array2 = { 3, 6, -1, 100, 77 };
		int [] array3 = Exam9.concat(array1, array2);
		
		Exam9.print(array3);
	}

}