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

public class BinaryArray extends BaseArray{
	protected int threshold;
	public BinaryArray(int size,int threshold) {
		super(size);
		this.threshold = threshold;
	}
	
	@Override
	public void print() {
		for(int n : array) {
			if(n > threshold)
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
	int threshold = 50; //임계값50
	BinaryArray bArray = new BinaryArray(10,threshold);
	//bArray 객체는 threshold 보다 크면 1, 아니면 0의값만 가지는 배열처럼 행동
	
	Scanner scanner = new Scanner(System.in);
	System.out.print(">>");
	for(int i=0;i<bArray.length();i++) {
		int n = scanner.nextInt();
		bArray.add(n);
	}
	bArray.print();
	scanner.close();

	}

}
