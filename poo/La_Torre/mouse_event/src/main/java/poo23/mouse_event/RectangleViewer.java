package poo23.mouse_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class RectangleViewer {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	public static void main( String[] args ){
    	final RectangleComponent component = new RectangleComponent();
    	
    	class MousePressListener implements MouseListener{
    		public void mousePressed(MouseEvent e) {
    			int x = e.getX();	
    			int y = e.getY();
    			component.moveTo(x, y);
    		}
    		
    		public void mouseClicked(MouseEvent e) {}
    		public void mouseReleased(MouseEvent e) {}
    		public void mouseEntered(MouseEvent e) {}
    		public void mouseExited(MouseEvent e) {}
    	}

    	MouseListener listener = new MousePressListener();
    	component.addMouseListener(listener);
    	
    	JFrame frame = new JFrame();
    	frame.add(component);
    	
    	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	frame.setVisible(true);
    }
}
