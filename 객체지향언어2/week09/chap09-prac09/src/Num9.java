import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Num9 extends JFrame{
	Num9(){
		setTitle("랜덤한 별을 가진 프레임");
		setSize(300,300)	;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.GRAY);
		northPanel.add(new JLabel("별 개수"));
		northPanel.add(new JTextField(10));
		northPanel.add(new JButton("별만들기"));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		JButton button = new JButton("Refresh");
		button.setSize(85,25);
		button.setLocation(10,10);
		centerPanel.add(button);
		for(int i=0;i<15;i++) {
			JLabel Label = new JLabel("*");
			Label.setForeground(Color.RED);
			int x = (int)(Math.random() * 280);
			int y = (int)(Math.random() * 180);
			Label.setLocation(x,y);
			Label.setSize(20,20);
			centerPanel.add(Label);
		}
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.YELLOW);
		southPanel.add(new JButton("Exit"));
		
		c.add(northPanel, BorderLayout.NORTH);
		c.add(centerPanel, BorderLayout.CENTER);
		c.add(southPanel, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Num9();
	}

}
