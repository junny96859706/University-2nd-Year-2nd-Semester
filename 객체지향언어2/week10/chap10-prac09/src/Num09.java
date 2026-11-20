import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
		
public class Num09 extends JFrame {

	public Num09() {
		setTitle("마우스 휠을 굴려 폰 ...");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel la = new JLabel("Love Java");
		la.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				JLabel label = (JLabel)e.getSource();
				Font f = label.getFont();
				int size = f.getSize();
				
				int n = e.getWheelRotation(); //휠방향판별
				if(n > 0) { //(양수):마우스 휠을 아래로 굴린경우(폰트크기 5증가)
	
					size = size+5;
					label.setFont(new Font(f.getName(), f.getStyle(), size));
						
				}
				else {//(음수):마우스 휠을 위로 굴린경우 (폰트크기 5감소)
					if(size<=5)
						return;
					size = size-5;
					label.setFont(new Font(f.getName(), f.getStyle(), size));
				}
			}
		});
		c.add(la);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Num09();
	}

}
