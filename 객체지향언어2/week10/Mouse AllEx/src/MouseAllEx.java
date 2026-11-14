import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAllEx extends JFrame {
	private JLabel text = new JLabel("");
	
	public MouseAllEx() {
		super("마우스");
		setSize(300,300);
		Container c = getContentPane();
		c.setLayout(null);
		c.add(text);
		text.setSize(100,20);
		text.setLocation(10,10);
		c.addMouseListener(new MyMouse());
		c.addMouseMotionListener(new MyMouse());
		
		setVisible(true);
	}
	
	class MyMouse extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			setTitle("pressed(" + x + "," + y + ")");
			text.setText("(" + x + "," + y + ")");
			text.setLocation(e.getPoint());
		}
		
		public void mouseReleased(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			setTitle("Released(" + x + "," + y + ")");
			text.setText("(" + x + "," + y + ")");
			text.setLocation(e.getPoint());
		}
		
		public void mouseEntered(MouseEvent e) {
			Component c = (Component)(e.getSource());
			c.setBackground(Color.CYAN);	
		}
		
		public void mouseExited(MouseEvent e) {
			Component c = (Component)(e.getSource());
			c.setBackground(Color.YELLOW);	
		}
		
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			setTitle("Dradded(" + x + "," + y + ")");
			text.setText("(" + x + "," + y + ")");
			text.setLocation(e.getPoint());
		}
		
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			setTitle("Moved(" + x + "," + y + ")");
			text.setText("(" + x + "," + y + ")");
			text.setLocation(e.getPoint());
		}
	}
	
	public static void main(String[] args) {
		new MouseAllEx();
	}

}
