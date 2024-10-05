package poo23.intersezione_cerchio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class IntersectionViewer {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String input = JOptionPane.showInputDialog("Inserisci la x");
        double x = Double.parseDouble(input);
        
        IntersectionComponent component = new IntersectionComponent(x);
        
        frame.add(component);
        frame.setVisible(true);
    }
}