package service;

import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import gui.FigureFrame.DrawingFigurePanel;
import model.CreateFigureCommand;
import model.Figure;

public class FigureService {

	private Stack<Figure> stack1;
	private Stack<Figure> stack2;
	private CreateFigureCommand createFigure;
	private Figure figure;

	public FigureService() {

		this.stack1 = new Stack<Figure>();
		this.stack2 = new Stack<Figure>();
	}

	public void execute(DrawingFigurePanel panel, MouseEvent e, boolean redoCalled) {

		if (!redoCalled) {
			figure.setSize(e.getX(), e.getY(), 200, 200);
			stack2.removeAllElements();
		}
		panel.paint(panel.getGraphics());
		createFigure = new CreateFigureCommand(figure);
		createFigure.createFigure(panel.getGraphics());
		stack1.add(figure);
	}

	public void undo(DrawingFigurePanel panel) {
		if (!stack1.isEmpty()) {
			Figure figure = stack1.pop();
			stack2.push(figure);
			Iterator<Figure> figures = getIterator(stack1);
			panel.setCount(0);
			panel.removeAll();
			panel.revalidate();
			panel.paint(panel.getGraphics());
			while (figures.hasNext()) {
				Figure fig = figures.next();
				new CreateFigureCommand(fig).createFigure(panel.getGraphics());
			}
		}
	}

	public void redo(DrawingFigurePanel panel) {

		if (!stack2.isEmpty()) {
			Figure fig = stack2.pop();
			setFigure(fig);
			stack1.push(fig);
			execute(panel, null, true);
		}
	}
	
	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	//Iterator Pattern
	public Iterator<Figure> getIterator(Collection<Figure> collection) {

		return collection.iterator();
	}


}
