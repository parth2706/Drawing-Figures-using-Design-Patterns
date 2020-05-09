package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FigureFrame {


	public JButton btnForCircle;
	public JButton btnForBox;
	public JButton btnForUndo;
	public JButton btnForRedo;
	public DrawingFigurePanel panel;

	public class DrawingFigurePanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public int count = 0;
		
		public DrawingFigurePanel() {
			setBackground(Color.WHITE);
		}
		
		public void paintComponent(Graphics g) {

			if (count == 0)
				super.paintComponent(g);
			count++;
		}
		
		public void setCount(int count) {
			this.count = count;
		}

	}

	public FigureFrame() {
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		panel = new DrawingFigurePanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(150, 0, 700, 700);
		
		btnForCircle = new JButton("Circle");
		btnForCircle.setBounds(20, 30, 130, 40);
		f.getContentPane().add(btnForCircle);
		
		btnForBox = new JButton("Box");
		btnForBox.setBounds(20, 100, 130, 40);
		f.getContentPane().add(btnForBox);
		
		btnForUndo = new JButton("Undo");
		btnForUndo.setBounds(20, 170, 130, 40);
		f.getContentPane().add(btnForUndo);
		
	
		btnForRedo = new JButton("Redo");
		btnForRedo.setBounds(20, 230, 130, 40);
		f.getContentPane().add(btnForRedo);
		
		f.getContentPane().add(panel);
	}

}
