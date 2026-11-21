import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Num1 extends JFrame{
	
	private JCheckBox check1;
	private JCheckBox check2;
	private JButton btn;
	
	public Num1() {
		setTitle("CheckBox ...");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyItemListener myitem = new MyItemListener();
		
		check1 = new JCheckBox("버튼 비활성화", false); //체크안되어있게 하기
		check1.addItemListener(myitem);
		c.add(check1);
		
		check2 = new JCheckBox("버튼 감추기", false); //체크안되어있게 하기
		check2.addItemListener(myitem);
		c.add(check2);
		
		btn = new JButton("test button");
		c.add(btn);
		
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox checkbox = (JCheckBox)e.getSource();
			
			if(checkbox == check1) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					btn.setEnabled(false); //활성화/비활성화
				}
				else
					btn.setEnabled(true);
			}
			
			if(checkbox == check2) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					btn.setVisible(false); //보이기/숨기기
				}
				else
					btn.setVisible(true);
			}
			
			/* 간략화버전!!!!!!!!
			 
			 if (checkbox == check1)
    			btn.setEnabled(e.getStateChange() == ItemEvent.DESELECTED);
			else if (checkbox == check2)
 	  			btn.setVisible(e.getStateChange() == ItemEvent.DESELECTED);
 	  			
			*/
		}
	}
	
	public static void main(String[] args) {
		new Num1();
	}

}
