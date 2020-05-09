package gui;

import service.FigureService;
import controller.FigureController;

public class MainAppToRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FigureFrame figFrame = new FigureFrame();
		FigureService service = new FigureService();
		FigureController controller = new FigureController(figFrame, service);
		controller.createFrame();
	}

}
