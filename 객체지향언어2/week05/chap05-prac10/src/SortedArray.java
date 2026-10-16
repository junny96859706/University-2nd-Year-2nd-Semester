import java.util.Scanner;

class BaseArray{
	protected int array []; //배열메모리
	protected int nextIndex = 0; //다음에 삽입할 배열에 대한 인덱스
	
	public BaseArray(int size) {
		array = new int[size];
	}
	
	public int length() {
		return array.length;
	}
	
	public void add(int n) { //정수 n을 배열끝에 추가
		if(nextIndex == array.length) //배열이 꽉 찼으면 추가 안함
			return;
		array[nextIndex] = n;
		nextIndex++;
	}
	
	public void print() {
		for(int n : array)
			System.out.print(n + " ");
		System.out.println();
	}
}

public class SortedArray extends BaseArray{
	public SortedArray(int size) {
		super(size);
	}
	
	@Override
	public void print() {
		nextIndex = 0; //배열인덱스 포인터 초기화
		
		for(int i=0; i<array.length; i++) {
			int minIndex = i;
			for(int j=i; j<array.length; j++) {
				if(array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		
		super.print();
	}
	
	
	
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		for(int i=0;i<sArray.length();i++) {
			int n = scanner.nextInt();
			sArray.add(n);
		}
		
		sArray.print();
		scanner.close();
	}

}
