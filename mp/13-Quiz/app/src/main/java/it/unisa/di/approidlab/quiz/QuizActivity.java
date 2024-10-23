package it.unisa.di.approidlab.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
	private TextView numeroQuesito;
	private TextView testoQuesito;
	private TextView risposteCorretteValide;
	private TextView risposteCorretteNonValide;
	private TextView risposteTotali;
	
	private int quesito_corrente = 0;
	private int valid_correct_answers = 0;
	private int non_valid_correct_answers = 0;
	private int total_answers = 0;
	
	private Quesito[] arrayDomande = new Quesito[] {
			new Quesito("Il risultato di 1+1 è 2", true),
			new Quesito("Il risultato di 1+1 è 3", false),
			new Quesito("Il risultato di 2+2 è 4", true),
			new Quesito("Il risultato di 2+2 è 5", false),
			new Quesito("Il risultato di 3*3 è 9", true),
			new Quesito("Il risultato di 3*4 è 9", false),
	};
	
	private final int NUM_QUESITI = arrayDomande.length;

	private boolean[] suggVisto = new boolean[NUM_QUESITI];

	private void aggiornaQuesito() {
		int n = quesito_corrente+1;
		numeroQuesito.setText("Quesito n. "+n);
		testoQuesito.setText(arrayDomande[quesito_corrente].getTesto());
		risposteCorretteValide.setText("Risposte corrette valide: "+valid_correct_answers);
		risposteCorretteNonValide.setText("Risposte corrette non valide: "+non_valid_correct_answers);
		risposteTotali.setText("Risposte totali: "+total_answers);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_layout);
		numeroQuesito = (TextView) findViewById(R.id.numeroQuesito);
		testoQuesito = (TextView) findViewById(R.id.testoQuesito);
		risposteCorretteValide = (TextView) findViewById(R.id.textRisposteCorretteValide);
		risposteCorretteNonValide = (TextView) findViewById(R.id.textRisposteCorretteNonValide);
		risposteTotali = (TextView) findViewById(R.id.textRisposteTotali);
		aggiornaQuesito();
		for (int i=0; i<NUM_QUESITI; i++) suggVisto[i]=false;
	}
	
	public void onClickAltroQuesito(View v) throws Exception {
		Button b = (Button) v;
		switch(b.getId()) {
			case R.id.buttonPrev: quesito_corrente--; break;
			case R.id.buttonSucc: quesito_corrente++; break;
			default: throw new Exception("Should not be here (prev/succ)");
		}
		quesito_corrente = quesito_corrente % NUM_QUESITI;
		aggiornaQuesito();
	}
	
	public void onClickRisposta(View v) throws Exception {
		total_answers++;
		Button b = (Button) v;
		Quesito q = arrayDomande[quesito_corrente];
		boolean risposta_corretta = q.getRisposta();
		boolean risposta;
		String str;
		switch(b.getId()) {
			case R.id.buttonTrue: risposta = true; break;
			case R.id.buttonFalse: risposta = false; break;
			default: throw new Exception("Should not be here (true/false)");
		}
		str = (risposta == risposta_corretta)  ? "Giusto!!!" : "Sbagliato.";
		Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();;
		
		if (risposta == risposta_corretta && !q.hasBeenCounted() ) {
			if (!suggVisto[quesito_corrente]) {
				valid_correct_answers++;
				}
			else {
				non_valid_correct_answers++;
			}
			aggiornaQuesito();
			q.setCounted();
		}
		quesito_corrente++;
		quesito_corrente = quesito_corrente % NUM_QUESITI;
		aggiornaQuesito();
	}
	
	public void onClickSuggerimento(View v) {
        Intent i = new Intent();
        i.setClass(getApplicationContext(), Suggerimento.class);
        i.putExtra("TESTO_QUESITO", arrayDomande[quesito_corrente].getTesto());
        i.putExtra("RISPOSTA_QUESITO", arrayDomande[quesito_corrente].getRisposta());
        startActivityForResult(i, 878);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode != 878) return;
	    if (resultCode != Activity.RESULT_OK) return;
	    if (data == null) return;
	    suggVisto[quesito_corrente] = data.getBooleanExtra("RISPOSTA_MOSTRATA", false);
	    Toast.makeText(getApplicationContext(), "Visto: "+suggVisto[quesito_corrente], Toast.LENGTH_LONG).show();
	}
}
