import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Num3 extends JFrame {
	Num3(){
		setTitle("GridLayout으로 10개의 버튼을 배치한 프레임");
		setSize(700,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(1,10);
		Container c = getContentPane();
		c.setLayout(grid);
		
		for(int i=0;i<10;i++) {
			String s = Integer.toString(i);
			c.add(new JButton(s));
		}2. bhu3
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Num3();
	}

}
