import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num3 extends JFrame{
	private ImageIcon icon = new ImageIcon("images/apple.jpg");
		
	private int imgW = icon.getIconWidth();
	private int imgH = icon.getIconHeight();
	
	
	public Num3() {
		setTitle("이미지 레이블 드레깅 연습 ...");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel apple = new JLabel(icon);
		apple.setSize(imgW, imgH);
		apple.setLocation(50, 50);
		
		MyMouse listener = new MyMouse();
		apple.addMouseListener(listener);
		apple.addMouseMotionListener(listener);
		c.add(apple);
		
		setVisible(true);
	}
	
	class MyMouse extends MouseAdapter{
		private int startX, startY; //마우스로 처음 잡은 지점
		
		@Override
		public void mousePressed(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			startX = e.getX();
			startY = e.getY();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			int x = label.getX() + e.getX() - startX;
			//(e.getX() - startX)는 이동량이다!!!!
			int y = label.getY() + e.getY() - startY;
			label.setLocation(x,y);
		}
	}
	
	public static void main(String[] args) {
		new Num3();
	}

}
