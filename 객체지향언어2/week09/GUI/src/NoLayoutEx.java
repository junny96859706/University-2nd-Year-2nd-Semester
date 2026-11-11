import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NoLayoutEx extends JFrame{
	
	public NoLayoutEx() {
		this.setTitle("절대 위치 절대 크기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		
		Container c = this.getContentPane();
		c.setBackground(Color.YELLOW);
		c.setLayout(null); //배치관리자 삭제
		
		for(int i=0;i<10;i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setSize(80,20); //b가 80,20을 기억한다.
			b.setLocation(10 + i*10, 10 + i*16); //b가 기억한다.
			c.add(b);
			
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton ba = (JButton)(e.getSource()); //다운캐스팅
					//ba는 눌려진 버튼
					ba.setBackground(Color.magenta);
				}
			});
		}
		
		JLabel text = new JLabel("안녕! GUI 해볼까?");
		text.setSize(100,20);
		text.setLocation(200, 100);
		c.add(text);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new NoLayoutEx();

	}

}
