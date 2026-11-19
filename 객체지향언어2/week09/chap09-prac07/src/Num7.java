import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Num7 extends JFrame{
	String [] Calculator = {
			"C", "UN", "BK", "/",
			"7", "8", "9", "x",
			"4", "5", "6", "-",
			"1", "2", "3", "+",
			"0", ".", "=", "%"
	};
	
	Num7(){
		setTitle("자바 스윙 계산기");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(); // 기본 배치관리자가 FlowLayout임!
		northPanel.setBackground(Color.LIGHT_GRAY);
		northPanel.add(new JLabel("수식"));
		northPanel.add(new JTextField(16));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5,4,5,5)); //수평,수직 간격주기
		for(int i=0;i<20;i++) {
			JButton btn = new JButton(Calculator[i]);
		    if (Calculator[i].equals("=")) {
		        btn.setBackground(Color.CYAN);
		    } //"="버튼만 포인트 색상 입히기
		    centerPanel.add(btn);
		}
		
		
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		// 기본 배치관리자가 FlowLayout임!(하단패널 왼쪽 정렬)
		southPanel.setBackground(Color.YELLOW);
		southPanel.add(new JLabel("계산 결과"));
		southPanel.add(new JTextField(16));
		
		c.add(northPanel, BorderLayout.NORTH);
		c.add(southPanel, BorderLayout.SOUTH);
		c.add(centerPanel, BorderLayout.CENTER);	
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Num7();
	}

}
