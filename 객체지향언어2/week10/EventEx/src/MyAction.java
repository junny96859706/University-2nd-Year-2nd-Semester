import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class MyAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); //다운캐스팅
		String text = b.getText();
		if(text.equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}
}
