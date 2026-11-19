import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num1 extends JFrame{
	public Num1(){
		setTitle("마우스 올..");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); //JFrame기본값은 BorderLayout이다!!
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.addMouseListener(new MyMouse());
		
		setVisible(true);
		
	}
	
	class MyMouse extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			label.setText("Love Java");
		}
		
		public void mouseExited(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			label.setText("사랑해 자바");
		}
	}
	
	
	public static void main(String[] args) {
		new Num1();
	}

}
