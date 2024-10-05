package poo23.rettangoli_casuali;

import javax.swing.JFrame;

public class App {
    public static void main( String[] args ){
        NumeriRettangoliFrame frame1 = new NumeriRettangoliFrame();
        RettangoliFrame frame = new RettangoliFrame(frame1.getNumero());
        
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
}
