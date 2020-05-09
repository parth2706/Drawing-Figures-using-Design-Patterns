package model;

import java.awt.Graphics;
// Adaptor Pattern
public class CreateFigureCommand implements CommandInterface{


	private Figure figure;
	
	public CreateFigureCommand(Figure figure) {
		
		this.figure = figure;
	}
	
	//Command Pattern
	@Override
	public void createFigure(Graphics g) {
		
		figure.draw(g);
	}

}
