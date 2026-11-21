import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JCompEx extends JFrame{
	public JCompEx() {
		setTitle("공통 메소드");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Magent/Yellow");
		JButton b2 = new JButton("Disabled Button");
		JButton b3 = new JButton("getX(). geyY()");
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b2.isEnabled())
					b2.setEnabled(false);
				else
					b2.setEnabled(true);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)(e.getSource()); //눌려진 버튼 알아내기
				Container c = b.getParent();
				c.remove(b1);
				c.repaint(); //12장에서 나온다
				c.revalidate(); //12장에서 나온다 , 위치재조정!!
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)(e.getSource()); //눌려진 버튼 알아내기
				JFrame f = (JFrame)b.getTopLevelAncestor();
				f.setTitle(b.getX() + "," + b.getY());
			}
			
		});
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JCompEx();
	}

}
