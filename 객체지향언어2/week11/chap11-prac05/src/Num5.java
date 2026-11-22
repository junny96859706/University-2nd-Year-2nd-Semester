import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Num5 extends JFrame {
	private JLabel label;
	
	public Num5() {
		setTitle("JSlider Practice Frame");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,100,200,160);
		slider.setPaintLabels(true);//슬라이더 label 보이게 한다
		slider.setPaintTicks(true); //슬라이더 눈금 보이게한다
		slider.setPaintTrack(true); //슬라이더의 트랙을 보이게 한다
		slider.setMajorTickSpacing(20); //슬라이더의 큰눈금간격을 보이게 한다
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sl = (JSlider)e.getSource();
				int num = sl.getValue();
				label.setText(Integer.toString(num));
			}
		});
		c.add(slider);
		
		label = new JLabel("160");
		label.setOpaque(true);
		label.setBackground(Color.GREEN);
		c.add(label);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Num5();
	}

}
