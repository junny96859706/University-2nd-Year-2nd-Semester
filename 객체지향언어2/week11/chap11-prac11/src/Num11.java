import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Num11 extends JFrame{
	private JButton[] button = new JButton[20];
	private String[] btnTexts = {
			"C", "UN", "BK", "/",
			"7", "8", "9", "x",
			"4", "5", "6", "-",
			"1", "2", "3", "+",
			"0", ".", "=", "%"
	};
	private JTextField calculation;
	private JTextField resultField;
	
	public Num11() {
		setTitle("공주의 계산기");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//----------북쪽패널---------
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		northPanel.setBackground(Color.LIGHT_GRAY);
		c.add(northPanel, BorderLayout.NORTH);
		
		//수식 라벨
		JLabel label1 = new JLabel("수식");
		northPanel.add(label1);
		
		//계산식 텍스트필드
		calculation = new JTextField(15);
		calculation.setHorizontalAlignment(SwingConstants.RIGHT);
		calculation.setEditable(false);
		northPanel.add(calculation);
		
		
		//--------센터패널-----------
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5,4));
		c.add(centerPanel, BorderLayout.CENTER);
		
		MyAction action = new MyAction();
		for(int i=0; i<button.length; i++) {
			button[i] = new JButton(btnTexts[i]);
			button[i].addActionListener(action);
			if(btnTexts[i].equals("="))
				button[i].setBackground(Color.CYAN);
			centerPanel.add(button[i]);
		}
		
		//------------남쪽패널------------
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.setBackground(Color.YELLOW);
		c.add(southPanel, BorderLayout.SOUTH);
		
		//수식 라벨
		JLabel label2 = new JLabel("계산 결과");
		southPanel.add(label2);
		
		//계산식 텍스트필드
		resultField = new JTextField(20);
		resultField.setHorizontalAlignment(SwingConstants.RIGHT);
		resultField.setEditable(false);
		southPanel.add(resultField);
		
		
		setVisible(true);
	}
	
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			String exp = calculation.getText();
			String btnName = btn.getText();
			
			
			if(btn.getText().equals("=")) {
				StringTokenizer st = new StringTokenizer(exp, "+-x/%", true);
				if(st.countTokens() != 3) {
					resultField.setText("한개의 연산만 할 수 있음");
					return;
				}
				
				double result = 0;
				double num1 = Double.parseDouble(st.nextToken().trim()); // 첫 번째 숫자
				String op = st.nextToken().trim();                  // 연산자 (+, -, x, /)
				double num2 = Double.parseDouble(st.nextToken().trim()); // 두 번째 숫자
				
				
				switch(op) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "x":
					result =num1 * num2;
					break;
				case "/":
					if(num2 == 0) {
						resultField.setText("0으로 나눌 수 없음.");
						return;
					}
					result = num1 / num2;
					break;
				case "%":
				    if (num2 == 0) {
				        resultField.setText("0으로 나눌 수 없음.");
				        return;
				    }
				    result = num1 % num2;
				    break;
					
				}
				
				if (result == (int) result) {
				    // 소수점 아래가 0이면 정수로 변환해서 출력 (예: 10.0 -> "10")
				    resultField.setText(Integer.toString((int) result));
				} 
				else {
				    // 소수점이 살아있으면 실수 그대로 출력 (예: 2.5 -> "2.5")
				    resultField.setText(Double.toString(result));
				}
			}
			else if(btn.getText().equals("C")) {
				calculation.setText("");
				resultField.setText("");
				return;
			}
			else if(btn.getText().equals("UN")) {
				if(exp.length() > 0) {
					calculation.setText(exp.substring(0,(exp.length()-1)));
				}
			}
			else if(btnName.equals("BK")){
				return; 
			}
			else{
				calculation.setText(exp + btnName);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new Num11();
	}

}
