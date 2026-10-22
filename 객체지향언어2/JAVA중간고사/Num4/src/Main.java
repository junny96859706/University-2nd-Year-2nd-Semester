public class Main {
	
	public static void main(String[] args) {
		int int1[] = new int[5];
		// [1, 10] 사이의 정수형 난수 5개 발생
		System.out.print("\n난수 5개 "); 
		for(int i=0; i<5; i++) {
			int1[i] = (int)(Math.random()*10 + 1);
			System.out.print(int1[i] + " "); // 난수 발생
		}
		Exam4 c1 = new Exam4();
		c1.print(c1.calc(int1));
		
		int int2[] = new int[6];
		// [1, 10] 사이의 정수형 난수 6개 발생
		System.out.print("\n난수 6개 "); 
		for(int i=0; i<6; i++) {
			int2[i] = (int)(Math.random()*10 + 1);
			System.out.print(int2[i] + " "); // 난수 발생
		}
		Exam4 c2 = new Exam4();
		c2.print(c2.calc(int2));
	}
}