package poo23.slider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame {
	private JPanel colorPanel;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	public SliderFrame() {
		colorPanel = new JPanel();
		add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		setSampleColor();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public void createControlPanel() {
		class ColorListener implements ChangeListener {
			public void stateChanged(ChangeEvent event) {
				setSampleColor();
			}
		}

		ChangeListener listener = new ColorListener();

		redSlider = new JSlider(0, 100, 100);
		redSlider.addChangeListener(listener);

		greenSlider = new JSlider(0, 100, 70);
		greenSlider.addChangeListener(listener);

		blueSlider = new JSlider(0, 100, 70);
		blueSlider.addChangeListener(listener);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 2));
		controlPanel.add(new JLabel("Rosso"));
		controlPanel.add(redSlider);
		controlPanel.add(new JLabel("Verde"));
		controlPanel.add(greenSlider);
		controlPanel.add(new JLabel("Blue"));
		controlPanel.add(blueSlider);
		
		add(controlPanel, BorderLayout.SOUTH);
	}

	public void setSampleColor() {
		float red = 0.01F * redSlider.getValue();
		float green = 0.01F * greenSlider.getValue();
		float blue = 0.01F * blueSlider.getValue();

		colorPanel.setBackground(new Color(red, green, blue));
		colorPanel.repaint();
	}
}
