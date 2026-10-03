
public class Num7 {

	public static void main(String[] args) {
		int []intArray = new int[10];
		System.out.print("랜덤한 정수들...");
		
		int sum = 0;
		
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = (int)(Math.random()*9) + 11; //11~19까지의 랜덤 함수
			System.out.print(intArray[i] + " ");
			sum += intArray[i];
			
			if(i == (intArray.length-1)) {
				System.out.println();
			}
		}
		
		System.out.print("평균은 " + (sum/10.0));
	}

}

//(double)(sum / 10) -> 이미 깎인 정수 결과를 double로 변환 (14.0) ❌
//(double) sum / 10 또는 sum / 10.0 -> 실수 연산으로 정확하게 계산 (14.5) ⭕