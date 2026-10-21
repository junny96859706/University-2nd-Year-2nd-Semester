
public class Exam9 {
	public static int[] concat(int a[],int b[]) {
		int temp_size = a.length+b.length;
		int []temp = new int[temp_size];
		
		for(int i=0; i<a.length; i++) // 배열 a를 tmp로 복사
			temp[i] = a[i];

		for(int i=0; i<b.length; i++) { // 배열 b를 tmp로 복사
			int index = a.length + i;
			temp[index] = b[i];
		}

		return temp;
		
	}
	
	public static void print(int[] a) { // 배열 a 출력
		System.out.print(" [");
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
	}
}
