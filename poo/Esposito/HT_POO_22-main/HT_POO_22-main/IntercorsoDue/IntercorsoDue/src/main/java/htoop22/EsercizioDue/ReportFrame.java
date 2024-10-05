package htoop22.EsercizioDue;

import javax.swing.*;

public class ReportFrame extends JFrame {

    public ReportFrame() {
        textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        textArea.setEnabled(false);
        scollPane = new JScrollPane(textArea);

        add(textArea);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * Metodo che permette di aggiungere testo alla text area
     * @param text il testo da aggiungere
     */
    void addTextToTextarea(String text) {
        this.textArea.append(text + "\n");
    }


    /**
     * Elementi grafici del frame di report
     */
    JTextArea textArea;
    JScrollPane scollPane;

    /**
     * Definiamo la grandezza della text area e del frame
     */
    private static final int AREA_ROWS = 5;
    private static final int AREA_COLUMNS = 20;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 300;
}
