import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Num5 extends JFrame{
	Color[] colors = {
		    Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,       // 0, 1, 2, 3
		    Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,        // 4, 5, 6, 7
		    Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY, // 8, 9, 10, 11
		    Color.BLACK, Color.ORANGE, Color.BLUE, Color.MAGENTA      // 12, 13, 14, 15
		};
	
	Num5(){
		super("4x4 Color 프레임");
		setSize(700,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,4));
		
		
		for(int i=0;i<16;i++) {
			JLabel label = new JLabel(Integer.toString(i));
			label.setOpaque(true);
			label.setBackground(colors[i]);
			c.add(label);
		}
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Num5();
	}

}
