import java.util.Scanner;

interface IStack{
	int capcity(); //스택에 저장 가능한 개수 리턴
	int length(); //스택에 현재 저장된 개수 리턴
	boolean push(String val); //스택의 톱(top)에 문자열 저장하고 true리턴
	                          //꽉 차서 넣을수 없으면 false리턴
	String pop(); //스택의 톱에 저장된 문자열 리턴, 스택이 비어 있으면 null리턴
}

public class StringStack implements IStack{
	int top = -1;
	String []Array;
	
	public StringStack(int size) {
		Array = new String[size];
	}
	
	@Override
	public boolean push(String val) {
		if(top == Array.length-1)
			return false;
		Array[++(top)] = val;
		return true;
	}
	
	@Override
	public String pop() {
		if(top == -1)
			return null;
		return Array[top--];
	}
	
	@Override
	public int capcity() {
		return (Array.length);
	}
	
	@Override
	public int length() {
		return (top+1);
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("스택용량>>");
		int size = scanner.nextInt();
		
		StringStack app = new StringStack(size);
		while(true) {
			System.out.print("문자열 입력>>");
			String study = scanner.next();
			if("그만".equals(study))
				break;
			if(app.push(study) == false) {
				System.out.println("스택이 꽉차서 " + study + " 저장 불가");
			}
		}
		
		System.out.print("스택에 저장된 문자열 팝 : ");
		  
		int count = app.length();
		for(int i=0; i < count; i++) {
			System.out.print(app.pop() + " ");
		}
		
		
		scanner.close();
	}

}
