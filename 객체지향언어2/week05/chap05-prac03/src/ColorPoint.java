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

public class ColorPoint extends Point{
	private String color = "";
	public ColorPoint(int x,int y,String color) {
		super(x,y);
		this.color = color;
	}
	
	protected void changeColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "color + "색의 " + "(" +
	}
		
	public static void main(String[] args) {
		
		
	}

}
