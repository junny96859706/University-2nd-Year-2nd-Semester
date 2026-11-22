import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num9 extends JFrame{
	private JLabel[] label = new JLabel[10];
	private int nextNum = 0;
	
	public Num9() {
		setTitle("Ten 레이블 클릭");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		MyMouse mymouse = new MyMouse();
		for(int i=0;i<10;i++) {
			int x = (int)(Math.random() * 250);
			int y = (int)(Math.random() * 250);
			label[i] = new JLabel(Integer.toString(i));
			label[i].setLocation(x,y);
			label[i].setSize(20,20);
			label[i].addMouseListener(mymouse);
			label[i].setForeground(Color.RED);
			c.add(label[i]);
		}
		
		setVisible(true);
	}
	
	class MyMouse extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			JLabel la = (JLabel)e.getSource();
			if(Integer.parseInt(la.getText()) == nextNum) {
				la.setVisible(false);
				nextNum++;
			}
			
			if(nextNum == 10) {
				nextNum = 0;
				for(int i=0;i<10;i++) {
					int x = (int)(Math.random() * 250);
					int y = (int)(Math.random() * 250);
					label[i].setLocation(x,y);
					label[i].setVisible(true);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Num9();
	}

}
