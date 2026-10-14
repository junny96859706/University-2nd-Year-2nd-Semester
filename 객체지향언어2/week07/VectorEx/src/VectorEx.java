import java.util.*;

public class VectorEx {
	
	public static int makeSum(Vector<Integer> v) {
		int sum = 0;
		for(int i=0;i<v.size();i++) {
			sum += v.elementAt(i);
		}
		
		return sum;
	}
	
	public static void print(Vector<Integer> v) {
		for(int i=0;i<v.size();i++) {
			//Integer n = v.get(i); //i번째 요소리턴
			//int m = n.intValue();
			
			//int m = v.get(i); //자동 언박싱!!!!!
			//(v.get(i) -> v.get(i).intValue()
			System.out.print(v.get(i) + " ");
		}
	}
	
	
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(3);
		v.add(5); //자동박싱 5->Integer.valueof(5)
		v.add(Integer.valueOf(4)); //원래는 이렇게!!!
		v.add(-1);
		//v.add("hello"); //에러(Integer타입만 가능)
		
		v.add(2,100);
		
		System.out.println("들어가있는 개수는" + v.size());
		System.out.println("용량은" + v.capacity());
		
		//Iterator를 이용하여 출력
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			int n = it.next(); //자동언박싱
			System.out.println(n);
		}
		
		
		System.out.println();
		
		
		System.out.println("합은 " + makeSum(v));
	}

}
