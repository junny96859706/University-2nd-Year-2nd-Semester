import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Num7 extends JFrame{
	private JLabel label;
	
	public Num7() {
		setTitle("JSlider Practice Frame");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,1,100,50);
		slider.setPaintLabels(true);//슬라이더 label 보이게 한다
		slider.setPaintTicks(true); //슬라이더 눈금 보이게한다
		slider.setPaintTrack(true); //슬라이더의 트랙을 보이게 한다
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20); //슬라이더의 큰눈금간격을 보이게 한다
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sl = (JSlider)e.getSource();
				int size = sl.getValue();
				label.setFont(new Font("Arial", Font.PLAIN, size));
			}
		});
		c.add(slider,BorderLayout.NORTH);
		
		label = new JLabel("Love Java");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 50));
		c.add(label);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Num7();
	}

}
