import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num5 extends JFrame{
	private Container c;
	
	public Num5() {
		setTitle("클릭 연습 응용프로 ...");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setLayout(null);
		
		JLabel la = new JLabel("c");
		la.setSize(20,20);
		la.setLocation(100,100);
		la.addMouseListener(new MyMouse());
		c.add(la);
		
		setVisible(true);
	}
	
	class MyMouse extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			int x = (int)(Math.random() * (c.getWidth() - label.getWidth()));
			int y = (int)(Math.random() * (c.getHeight() - label.getHeight()));
			label.setLocation(x,y);
		}
	}
	
	public static void main(String[] args) {
		new Num5();
	}

}
