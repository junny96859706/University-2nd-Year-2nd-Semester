class Shape{
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape{
	public void draw() { //오버라이딩
		System.out.println("Line");
	}
}

class Circle extends Shape{
	public void draw() { //오버라이딩
		System.out.println("Circle");
	}
}

class Rect extends Shape{
	public void draw() { //오버라이딩(동적바인딩으로 우선처리 한다)
		System.out.println("Rect");
	}
}


public class GraphicEditor {
	
	public static void print(Shape p) {
	//P는 Shape객체이거나 Shape를 상속받은 객체에 대한 레퍼런스
		p.draw();
	}
	
	public static void main(String[] args) {
		Line line = new Line();
		Shape shape = line; //업케스팅발생
		
		line.draw(); //Line클래스의 draw()호출
		shape.draw(); //Shape 클래스의 draw()호출 -> 동적바인딩에 의해 Line클래스의 draw()실행
	
		
	}
}
