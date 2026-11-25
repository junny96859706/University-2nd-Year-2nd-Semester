import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Num2 extends JFrame{
	
	public Num2() {
		setTitle("이미지 위에 원 드래깅 연습");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel panel = new MyPanel();
		setContentPane(panel);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private MyMouse listener = new MyMouse();
		private int x = 300, y = 100; //원의 좌표
		
		public MyPanel() {
			addMouseMotionListener(listener);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.GREEN);
			g.fillOval(x-20, y-20, 40, 40);
		}
		
		class MyMouse extends MouseAdapter{
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int mouseX = e.getX();
				int mouseY = e.getY();
				if(mouseX >= x-20 &&  mouseX <= x+20 && mouseY >= y-20 && mouseY <= y+20) {
					x = mouseX;
					y = mouseY;
					repaint();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Num2();
	}
}
