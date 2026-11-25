import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Num11 extends JFrame{
	private int[] data = {0, 0, 0, 0};
	private int[] arcAngle = new int[4];
	private int sum;
	private Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE};
	
	private String[] fruit = {"apple", "cherry", "strawberry", "prune"};
	private JTextField [] filed = new JTextField[4];
	
	private MyPanel panel = new MyPanel(); //센터패널
	
	public Num11() {
		setTitle("파이 차트 그리기");
		setSize(550,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//----------북쪽패널------------
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		northPanel.setBackground(Color.GRAY);
		
		MyAction listener = new MyAction();
		for(int i=0;i<4;i++) {
			northPanel.add(new JLabel(fruit[i]));
			filed[i] = new JTextField("0", 7);
			filed[i].addActionListener(listener);
			northPanel.add(filed[i]);
		}
		c.add(northPanel, BorderLayout.NORTH);
		
		
		//-----------센터 패널---------
		c.add(panel, BorderLayout.CENTER);
		panel.repaint();
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		
		public MyPanel() {
			setLayout(null);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (sum == 0) return;
			
			for(int i=0;i<4;i++) {
				int persent = (int)(Math.round((double)data[i] / sum * 100));
				arcAngle[i] = (int) Math.round((double) data[i] / sum * 360);
				g.setColor(color[i]);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
				g.drawString(fruit[i] + " " + persent + "%", (50+i*110), 20);
			}
			
			int startAngle = 0;
			for(int i=0;i<4;i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, arcAngle[i]);
				startAngle += arcAngle[i];
			}
		}
	}
	
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			sum = 0; //매번 새로 합산하도록 0으로 초기화!
			for(int i=0;i<4;i++) {
				int text = Integer.parseInt(filed[i].getText());
				data[i] = text;
				sum += data[i];
			}
			panel.repaint();
		}
	}
	
	public static void main(String[] args) {
		new Num11();
	}

}
