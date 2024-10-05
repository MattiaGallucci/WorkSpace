package poo23.print_on_click;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonTester {
    public static void main( String[] args ){
        final int FRAME_WIDTH = 100;
        final int FRAME_HEIGHT = 160;
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button = new JButton("Cliccami!");
        frame.add(button);
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
        
        frame.setVisible(true);
    }
}
