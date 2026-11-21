import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Num3 extends JFrame{
	
	String[] moneyName = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원" };
	JTextField[] inputTF = new JTextField[8];
	private JTextField totalField;
	private int[] units = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	
	public Num3() {
		setTitle("Money Changer");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		c.add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.YELLOW);
		
		JLabel totalLabel = new JLabel("금액");
		totalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		topPanel.add(totalLabel);
		
		totalField = new JTextField(10);
		topPanel.add(totalField);
		
		MyAction action = new MyAction();
		JButton button = new JButton("계산");
		button.addActionListener(action);
		topPanel.add(button);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(8,2));
		c.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.YELLOW);
		
		for(int i=0;i<8;i++) {
			centerPanel.add(new JLabel(moneyName[i]));
			inputTF[i] = new JTextField();
			inputTF[i].setHorizontalAlignment(SwingConstants.CENTER);
			centerPanel.add(inputTF[i]);
			
		}
		
		setVisible(true);
	}
	
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int money = Integer.parseInt(totalField.getText());
			
			for (int i = 0; i < units.length; i++) {
			    int count = money / units[i];                 // 2. 몫 = 화폐 개수
			    inputTF[i].setText(Integer.toString(count)); // 3. 숫자를 다시 글자로 바꿔 출력
			    money = money % units[i];                     // 4. 나머지 = 남은 돈 갱신 (핵심!)
			}
		}
	}

	public static void main(String[] args) {
		new Num3();
	}

}
