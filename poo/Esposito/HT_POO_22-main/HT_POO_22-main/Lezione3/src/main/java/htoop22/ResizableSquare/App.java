package htoop22.ResizableSquare;
import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Resizable Square Component");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String input = JOptionPane.showInputDialog("Inserisci il lato del quadrato");
        double lato = Double.parseDouble(input);

        ResizableSquareComponent component = new ResizableSquareComponent(lato);
        frame.add(component);

        frame.setVisible(true);
    }
}
