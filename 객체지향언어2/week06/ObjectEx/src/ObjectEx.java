
class Point{ //사실은 Object를 상속받고있음
	private int x,y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() { //toString() 오버라이딩
		return "(" + x + "," +y + ")";
	}
	
	public boolean equals(Object obj) { //오버라이딩
		Point p = (Point)obj; //다운캐스팅
		if(x == p.x && y == p.y)
			return true;
		return false;
	}
}

public class ObjectEx { //사실은 Object를 상속받고있음

	public static void print(Object obj) { //업캐스팅해서 전달!!
		Class c = obj.getClass();
		String name = c.getName();
		System.out.println(name);
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args) {
		Point p = new Point(2,3);
		//print(p);
		//print(new String("hello"));
		
		/*Point a = new Point(2,3);
		Point b = new Point(2,3);
		Point c = a;
		
		if(a == b) 
			System.out.println("a==b");
		if(a == c) 
			System.out.println("a==c");
		
		if(a.equals(b))
			System.out.println("a equals b"); */
		
		
		int n = 10;
		Integer ten = Integer.valueOf(n); //수동 박싱
		int x = ten.intValue(); //수동 언박싱
		
		System.out.println(x);
	}

}
 