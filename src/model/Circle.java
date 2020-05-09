package model;

import java.awt.Graphics;

public class Circle implements Figure{

	private Size size;
	
	public Circle() {
		this.size = new Size();
	}

	//Expert Pattern
	@Override
	public void draw(Graphics g) {

		g.drawOval(size.getXCor(), size.getYCor(), size.getWidth(), size.getHeight());
	}

	//Expert Pattern
	@Override
	public void setSize(int x, int y, int width, int height) {
		
		size.setSize(x, y, width, height);
	}


}
