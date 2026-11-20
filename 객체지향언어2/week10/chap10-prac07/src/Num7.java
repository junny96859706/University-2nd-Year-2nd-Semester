import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Num7 extends JFrame{

	public Num7() {
		super("클릭 횟수 카운트");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton[] button = new JButton[5];
		MyMouse listener = new MyMouse();
		for(int i=0;i<5;i++) {
			button[i] = new JButton("0");
			button[i].addMouseListener(listener);
			c.add(button[i]);
		}
		
		setVisible(true);
	}
	
	class MyMouse extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton bt = (JButton)e.getSource();
			String str = bt.getText();
			int num = Integer.parseInt(str);
			num++;
			str = Integer.toString(num);
			bt.setText(str);
			
		}
	}
	
	public static void main(String[] args) {
		new Num7();
	}

}
