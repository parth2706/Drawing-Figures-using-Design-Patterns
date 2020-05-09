package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import service.FigureService;
import gui.FigureFrame;
import model.Circle;
import model.Box;

//Controller Pattern, Observer Pattern
public class FigureController  implements MouseListener{
	
	private FigureFrame figFrame;
	private FigureService service;
	
	public FigureController(FigureFrame figFrame, FigureService service) {
		
		this.figFrame = figFrame;
		this.service = service;
	}
	
	public void createFrame() {
		
		this.figFrame.btnForCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.setFigure(new Circle());
			}
		});
		
		this.figFrame.btnForBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.setFigure(new Box());
			}
		});
		
		this.figFrame.btnForUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.undo(figFrame.panel);
			}
		});
		
		this.figFrame.btnForRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.redo(figFrame.panel);
			}
		});
		
		figFrame.panel.addMouseListener(this);
	}
	
	
	public void mouseClicked(MouseEvent e) {

		service.execute(figFrame.panel, e, false);
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
