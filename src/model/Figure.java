package model;

import java.awt.Graphics;

//Composite Pattern
public interface Figure {

    void draw(Graphics g);
	
	void setSize(int xCor, int yCor, int width, int height);
}
