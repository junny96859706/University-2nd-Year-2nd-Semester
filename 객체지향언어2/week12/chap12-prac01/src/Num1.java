import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Num1 extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public Num1() {
		setTitle("이미지 그리기 연습");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private JButton btn = new JButton("Hide/Show");
		private boolean showFlag = true; //이미지 표시 여부 토글 변수
		
		public MyPanel() {
			setLayout(new FlowLayout()); //JPanel 기본값이다
			add(btn);
			
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showFlag = !showFlag;
					repaint(); 
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(showFlag) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}
	
	public static void main(String[] args) {
		new Num1();
	}

}
