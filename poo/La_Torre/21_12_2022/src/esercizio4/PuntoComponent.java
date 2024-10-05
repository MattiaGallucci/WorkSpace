package esercizio4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import esercizio2.CentroUrbanoMappa;

public class PuntoComponent extends JComponent{
	ArrayList<CentroUrbanoMappa> centri;
	
	public PuntoComponent(ArrayList<CentroUrbanoMappa> c) {
		centri = c;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<centri.size(); i++) {
			Ellipse2D.Double cerchio = new Ellipse2D.Double(centri.get(i).getPuntoMappa().getLatitudine()-2, centri.get(i).getPuntoMappa().getLongitudine()-2, 4, 4);
			
			g2.draw(cerchio);
			
			String label = centri.get(i).getNome() + "(" + centri.get(i).getPuntoMappa().getLatitudine() + "," + centri.get(i).getPuntoMappa().getLongitudine() + ")";
			g2.drawString(label, (float) centri.get(i).getPuntoMappa().getLatitudine(), (float) centri.get(i).getPuntoMappa().getLongitudine());
		}
	}
}
