package model;

import java.awt.Graphics;

//Composite Pattern
public class Box implements Figure{

	private Size size;
	public Box() {
		this.size = new Size();
	}
	
	//Expert Pattern
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(size.getXCor(), size.getYCor(), size.getWidth(), size.getHeight());
	}
    
	//Expert Pattern
	@Override
	public void setSize(int xCor, int yCor, int width, int height) {
		// TODO Auto-generated method stub
		size.setSize(xCor, yCor, width, height);
	}

}
