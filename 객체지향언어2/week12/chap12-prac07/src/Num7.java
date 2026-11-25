import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Num7 extends JFrame {
	
	public Num7() {
		setTitle("마우스로 폐다각형 그리기");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel panel = new MyPanel();
		setContentPane(panel);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private Vector<Integer> xList = new Vector<Integer>();
		private Vector<Integer> yList = new Vector<Integer>();
		
		public MyPanel(){ //생성자 함수
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					xList.add(e.getX());
					yList.add(e.getY());
					repaint();
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			
			int n = xList.size();
			int[] x = new int[n];
		    int[] y = new int[n];

		    for (int i = 0; i < n; i++) {
		        x[i] = xList.get(i);
		        y[i] = yList.get(i);
		    }
		    
			g.drawPolygon(x,y,n);
		}
	}
	
	public static void main(String[] args) {
		new Num7();
	}

}
