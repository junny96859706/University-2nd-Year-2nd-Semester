import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	public MyFrame() {
		//super("첫 GUI"); //JFrame의 생성자 호출
		//타이틀바를 매개변수로 받는 생성자
		setTitle("첫 GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		this.setSize(500, 500);
		this.setResizable(false);
		Container c = this.getContentPane(); //컨텐트팬 영역의 객체 알려줘
		c.setBackground(Color.ORANGE);
		
		/*c.setLayout(new BorderLayout(30 , 10)); //배치관리자
		c.add(new JButton("OK"), BorderLayout.NORTH);
		c.add(new JButton("Cancel"),BorderLayout.SOUTH);
		c.add(new JButton("Ignore"),BorderLayout.EAST);
		c.add(new JButton("Hello"),BorderLayout.WEST);
		c.add(new JButton("안녕하세요"),BorderLayout.CENTER);
		*/
		
		c.setLayout(new GridLayout(3,4, 10,10));
		for(int i=0; i<12; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setBackground(Color.GREEN);
			b.setFont(new Font("고딕체" , Font.ITALIC, 50));
			c.add(b);
		}
		
		
		this.setVisible(true); //화면에 그려라라는 지시
	}

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		System.out.println("메인종료합니다.");

	}

}
