class Point{
	private int x,y;
	public Point(int x,int y) {
		this.x = x; this.y = y;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	protected void move(int x, int y) {
		this.x = x; this.y = y;
	}
}

public class Point3D extends Point{
	private int z; //z축의 좌표값
	public Point3D(int x,int y,int z) {
		super(x,y);
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + z + ")" + "의 점";
	}
	
	public void moveUp(int up) {
		z += up;
	}
	
	public void moveDown(int down) {
		z -= down;
	}
	
	// 매개변수 2개짜리 move (z축은 기존 값 유지)
		public void move(int x, int y) {
			super.move(x, y);
		}
	
	public void move(int x,int y,int z) {
		super.move(x,y);
		this.z = z;
	}
	
	
	public static void main(String[] args) {
		Point3D p = new Point3D(3,2,1);
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(3);
		System.out.println(p.toString() + "입니다.");
		p.moveDown(2);
		System.out.println(p.toString() + "입니다.");
		p.move(5, 5);
		System.out.println(p.toString() + "입니다.");
		p.move(100,200,300);
		System.out.println(p.toString() + "입니다.");
	}

}
