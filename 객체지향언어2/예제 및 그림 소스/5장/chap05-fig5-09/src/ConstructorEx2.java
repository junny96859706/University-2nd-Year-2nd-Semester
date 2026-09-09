class A {
	public A() {
		System.out.println("생성자A");
	}
	public A(int x) {
		// .....
	}
}

class B extends A {
	public B() {
		System.out.println("생성자B");
	}
}

public class ConstructorEx2 {
	public static void main(String[] args) {
		B b;
		b = new B();
	}
}
