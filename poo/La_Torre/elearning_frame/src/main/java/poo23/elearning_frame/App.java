package poo23.elearning_frame;

import javax.swing.JFrame;

public class App {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
    public static void main( String[] args ){
    	JFrame frame = new JFrame();
    	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Component component = new Component();
    	frame.add(component);
    	
    	frame.setVisible(true);
    }
}
