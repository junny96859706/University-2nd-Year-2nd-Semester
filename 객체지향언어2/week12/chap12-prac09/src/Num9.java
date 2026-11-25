import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num9 extends JFrame{

	public Num9() {
		setTitle("Blue Label 만들기");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		BlueLabel label1 = new BlueLabel("hello");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        label1.setBackground(Color.RED); // 다른 색으로 변경 시도해도 무시됨!
        c.add(label1);

        BlueLabel label2 = new BlueLabel("Big Hello");
        label2.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        label2.setBackground(Color.YELLOW); // 다른 색으로 변경 시도해도 무시됨!
        c.add(label2);
		
		setVisible(true);
	}
	
	class BlueLabel extends JLabel {
        public BlueLabel(String text) {
            super(text); // 부모 JLabel에 텍스트 전달 -> 알아서 글자 크기에 맞춰 컴포넌트 크기 계산!
        }

        public BlueLabel(ImageIcon icon) {
            super(icon); 
        }

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, getWidth(), getHeight());

            super.paintComponent(g);
           
        }
    }
	
	public static void main(String[] args) {
		new Num9();
	}

}
