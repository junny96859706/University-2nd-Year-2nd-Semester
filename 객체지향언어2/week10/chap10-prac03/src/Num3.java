import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num3 extends JFrame{
	public Num3() {
		setTitle("Left키로 ...");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel la = new JLabel("Love Java");
		c.add(la);
		
		la.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				JLabel label = (JLabel)e.getSource();
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_LEFT) {
					//etText()는 화면에 표시되는 컴포넌트의 글자(텍스트)를 가져오는 메서드이고, 
					//getName()은 개발자가 내부 식별용으로 붙여둔 컴포넌트 객체 자체의 고유 이름을 가져오는 메서드
					String first = label.getText().substring(0,1); //0번인덱스부터 1-1위치까지 잘라낸다!
					String other = label.getText().substring(1); //1번인덱스부터 끝까지
					String rotation = other + first;
					label.setText(rotation);
				}
			}
		});
		
		
		setVisible(true);
		la.setFocusable(true);
		la.requestFocus();
	}
	
	public static void main(String[] args) {
		new Num3();
	}

}
