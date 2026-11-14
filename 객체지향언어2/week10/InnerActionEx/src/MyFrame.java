import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Action 이벤트 리스너");
		setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b = new JButton("Action");
		c.add(b);
		//b.addActionListener(new MyAction()); //이벤트 리스너 등록
		b.addActionListener(new ActionListener() { //익명클래스
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource(); //다운캐스팅
				String text = b.getText();
				if(text.equals("Action"))
					b.setText("액션");
				else
					b.setText("Action");
				
				setTitle(b.getText());
			}
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MyFrame();

	}
}