package app.calcolatricemia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView display1;
    TextView display2;
    String operator = "";
    String str2 = "";
    float op1 = 0;
    float op2 = 0;
    float res = 0;
    boolean punto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
    }

    public static String findOperator(String str) {
        if (str == null || str.isEmpty()) {
            return ""; // Gestione di stringhe nulle o vuote
        }
        // Controlla la presenza degli operatori e restituisci il primo trovato
        if (str.contains("+")) {
            return "+"; // Restituisce "+" se trovato
        } else if (str.contains("-")) {
            return "-"; // Restituisce "-" se trovato
        } else if (str.contains("*")) {
            return "*"; // Restituisce "*" se trovato
        } else if (str.contains("/")) {
            return "/"; // Restituisce "/" se trovato
        }
        return "";
    }

    public float calculate(float op1, float op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 == 0)
                    return 0;
                return op1 / op2;
            default:
                return 0;
        }
    }

    public void showPartialRes(String expr) {
        if (expr.isEmpty()) {
            return;
        }
        operator = findOperator(expr);
        if (!operator.isEmpty()) {
            String[] parts = expr.split("[+\\-*/]");
            if (parts.length > 1) {
                op1 = Float.parseFloat(parts[0]);
                op2 = Float.parseFloat(parts[1]);
                res = calculate(op1, op2, operator);
                display2.setText("" + res);
            } else {
                display2.setText("" + op1);
            }
        } else {
            display2.setText("" + expr);
        }
    }

    public void digitClicked(View v) {
        Button b = (Button) v;
        String str = (String) display1.getText();
        String expr = str + b.getText();
        if (operator.isEmpty()) {
            display1.setText(expr);
            showPartialRes(expr);
        } else {
            display1.setText(expr);
            str2 = str2 + b.getText();
            op2 = Float.parseFloat(str2);
            showPartialRes(expr);
        }

    }

    public void operatorClicked(View v) {
        Button b = (Button) v;
        if (!operator.isEmpty())
            return;

        String str = (String) display1.getText();
        op1 = Float.parseFloat(str);
        operator = b.getText().toString();
        display1.setText(str + operator);
        showPartialRes(str);
        punto = false;
    }

    public void elClicked(View v) {
        Button b = (Button) v;
        String str = (String) display1.getText();  // Ottieni la stringa da display1

        if (str.isEmpty()) {
            display2.setText("");  // Cancella display2 se la stringa è vuota
        } else {
            if (str.length() == 1) {
                display2.setText("");
            }
            char lastChar = str.charAt(str.length() - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                operator = "";  // Se è un operatore, resettalo
            }
            if (lastChar == '.')
                punto = false;
            display1.setText(str.substring(0, str.length() - 1));
            showPartialRes(str.substring(0, str.length() - 1));
        }
    }

    public void resClicked(View v) {
        Button b = (Button) v;
        String str = (String) display2.getText();
        display1.setText(str);
        op1 = Float.parseFloat(str);
        op2 = 0;
        operator = "";
        display2.setText("");
    }

    public void azzeraClicked(View v) {
        Button b = (Button) v;
        display1.setText("");
        op1 = 0;
        op2 = 0;
        operator = "";
        display2.setText("");
        punto = false;
    }

    public void puntoClicked(View v) {
        Button b = (Button) v;
        String str = (String) display1.getText();
        if (str.contains(".")){
            return;
        }
        if (!punto) {
            punto = true;
            display1.setText(str + b.getText());
        }
    }
}