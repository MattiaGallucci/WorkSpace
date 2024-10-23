package it.unisa.di.approidlab.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Suggerimento extends Activity {
    private TextView textViewQuesito;
    private TextView textViewRisposta;
    private String quesito;
    private boolean risposta;
    private boolean rispostaMostrata = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_suggerimento);

        textViewQuesito = (TextView) findViewById(R.id.testoQuesito);
        textViewRisposta = (TextView) findViewById(R.id.testoRisposta);

        Intent i = getIntent();
        quesito = i.getStringExtra("TESTO_QUESITO");
        risposta = i.getBooleanExtra("RISPOSTA_QUESITO", risposta);

        textViewQuesito.setText(quesito);
        setReturnIntent();
    }

    private void setReturnIntent() {
        Intent data = new Intent();
        data.putExtra("RISPOSTA_MOSTRATA", rispostaMostrata);
        setResult(RESULT_OK, data);
    }

    public void onClickMostra(View v) {
        textViewRisposta.setText("" + risposta);
        rispostaMostrata = true;
        setReturnIntent();
    }

    public void onClickTorna(View v) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "onBack pressed", Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }
}
