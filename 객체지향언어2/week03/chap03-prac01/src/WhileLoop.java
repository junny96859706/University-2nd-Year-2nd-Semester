
public class WhileLoop {

	public static void main(String[] args) {
		int sum=0,i=1;
		while(true) { //i = 1,4,7,10 ... 28까지의 총합을 표현하는 프로그램
			if(i > 30)
				break;
			sum = sum+i;
			i +=3;
		}
		
		System.out.println("총합1은 "+ sum + "입니다");
		
		
		int forSum=0;
		for(i=1;i<30;i=i+3) {
			forSum +=i;
		}
		System.out.println("총합2은 "+ forSum + "입니다");
		
		
		int doWhileSum = 0;
		i=1;
		do {
			doWhileSum += i;
			i+=3;
		}while(i<30);
		System.out.println("총합3은 "+ doWhileSum + "입니다");

	}

}
