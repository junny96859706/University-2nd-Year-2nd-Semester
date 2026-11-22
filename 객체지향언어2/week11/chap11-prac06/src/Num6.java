import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Num6 extends JFrame {
	private JTextArea ta;
	private JSlider slider;
	
	public Num6() {
		setTitle("TextArea Practice Fra ...");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//텍스트 영역
		ta = new JTextArea(5,20);
		ta.setBackground(Color.WHITE);
		ta.setLineWrap(true); //자동 줄바꿈
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextArea textArea = (JTextArea)e.getSource();
				int len = textArea.getText().length();
				if(len > 100) {
					textArea.setText(ta.getText().substring(0,100));
					len = 100;
				}
				slider.setValue(len);
			}
		});
		c.add(ta, BorderLayout.NORTH);
		
		//슬라이더 영역
		slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		slider.setPaintLabels(true);//슬라이더 label 보이게 한다
		slider.setPaintTicks(true); //슬라이더 눈금 보이게한다
		slider.setPaintTrack(true); //슬라이더의 트랙을 보이게 한다
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20); //슬라이더의 큰눈금간격을 보이게 한다
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sl = (JSlider)e.getSource();
				int len = ta.getText().length();
				int num = sl.getValue();
				if(len > num) {
					ta.setText(ta.getText().substring(0,num));
				}
			}
		});
		c.add(slider, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Num6();
	}

}

