import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	private JLabel text = new JLabel("hello"); // (0,0). 0x0의 크기로 생성
	public MyFrame() {
		setTitle("마우스로 문자열 이동");
		setSize(300,300);
		Container c = this.getContentPane();
		
		//마음대로 이동시키고자 c의 배치관리자를 null로 설정
		c.setLayout(null); //배치관리자 삭제
		c.add(text);
		c.addMouseListener(new MouseAdapter() { //익명의 클래스와 객체 생성
			public void mousePressed(MouseEvent e) { //오버라이딩. 마우스가 눌러지는 순간 호츌
				int x = e.getX();
				int y = e.getY();
				text.setLocation(x,y);
			}
		});
		
		//text의 위치와 크기를 내가 설정
		text.setSize(60,20);
		text.setLocation(10,10);
		
		setVisible(true);
		
	}
	
	/*class MyMouse extends MouseAdapter { //추상메소드 5개
		public void mousePressed(MouseEvent e) { //오버라이딩. 마우스가 눌러지는 순간 호츌
			int x = e.getX();
			int y = e.getY();
			text.setLocation(x,y);
		}
	}*/
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
