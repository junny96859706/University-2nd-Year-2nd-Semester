import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	private JLabel text = new JLabel("hello");
	public MyFrame() {
		super("키 이벤트 처리");
		setSize(300,300);
		
		Container c = getContentPane();
		c.setLayout(null); //배치관리자 제거
		text.setSize(60,20);
		text.setLocation(10,10);
		c.add(text);
		
		c.addKeyListener(new MyKey());
		
		
		setVisible(true); //그리고 나서 포커스를 임의의 컴포넌트에게 준다.
		
		c.setFocusable(true);
		c.requestFocus(); //포커스를 주는 코드
	}
	
	class MyKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			//text의 현재 위치
			int x = text.getX();
			int y = text.getY();
			
			int code = e.getKeyCode(); //가상키 리턴
			switch(code) {
			case KeyEvent.VK_UP : text.setLocation(x, y-10); break;
			case KeyEvent.VK_DOWN : text.setLocation(x, y+10); break;
			case KeyEvent.VK_LEFT : text.setLocation(x-10, y); break;
			case KeyEvent.VK_RIGHT : text.setLocation(x+10, y); break;
			case KeyEvent.VK_Q : System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
