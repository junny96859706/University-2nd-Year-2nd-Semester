import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Num1 extends JFrame{
	public Num1() {
		setTitle("Make a Window using Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.YELLOW);
		c.setLayout(null);
		
		setSize(400,150);
		setVisible(true);
		//setVisible(true)를 맨 뒤에 두어야 한다!!
		//호출되는 바로 그 순간에 자바가 프레임과 그 안의 모든 컴포넌트를 
		//실제 모니터 화면에 그리기(렌더링) 시작하기 때문.
	}
	
	
	public static void main(String[] args) {
		new Num1();
	}

}
