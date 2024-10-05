package esercizio4;

import java.util.ArrayList;

import javax.swing.JFrame;

import esercizio2.CentroUrbanoMappa;
import esercizio3.Centri;
import esercizio3.Criterio;

public class MappaFrame extends JFrame {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	private Centri<CentroUrbanoMappa> centri;

	private PuntoComponent punto;

	public MappaFrame(Centri<CentroUrbanoMappa> c) {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		centri = c;

		class CriterioVero implements Criterio<CentroUrbanoMappa> {
			public boolean useCriterio(CentroUrbanoMappa item) {
				return true;
			}
		}
		Criterio<CentroUrbanoMappa> criterioVero = new CriterioVero();
		centri.setCriterio(criterioVero);

		punto = new PuntoComponent(centri.getCentriByCriterio());
		add(punto);

	}
}
