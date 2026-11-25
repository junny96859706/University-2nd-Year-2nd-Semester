import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Num5 extends JFrame{
	
	public Num5() {
		setTitle("그래픽 이미지 확대 축소 연습");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel panel = new MyPanel();
		setContentPane(panel);
		
		setVisible(true);
		panel.requestFocus(); //화면이 뜬 직후 패널에 키 포커스 확실히 부여
		// 반드시 setVisible(true) 다음에 호출!
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/apple.jpg");
		private Image img = icon.getImage();
		
		private int width = icon.getIconWidth();
		private int height = icon.getIconHeight();
		//해결책: ImageIcon은 생성 즉시 이미지 크기를 동기적으로 불러오므로, 
		//안전하게 icon.getIconWidth()와 icon.getIconHeight()를 쓰는것이 좋다
		//img.getHeight(this)가 이미지 로딩이 완전히 끝나기 전 생성 시점에는 -1을 반환할 수 있다
		
		public MyPanel() {
			//JPanel은 기본적으로 키 입력 포커스를 받지 못한다!!!
			//키이벤트가 작동할수 있도록 포커스를 설정한다.
			setFocusable(true);
			
			MyKey listener = new MyKey();
			addKeyListener(listener);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 10, 10, width, height, this);
		}
		
		class MyKey extends KeyAdapter{
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '+') {
					width = (int)(width*1.1);
					height = (int)(height*1.1);
					repaint();
				}
				else if(e.getKeyChar() == '-'){
					width = (int)(width*0.9);
					height = (int)(height*0.9);
					repaint();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Num5();
	}

}
