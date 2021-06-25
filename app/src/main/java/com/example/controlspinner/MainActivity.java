package com.example.controlspinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;
    private EditText ed1, ed2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        tv1 = findViewById(R.id.textView);
        sp1 = findViewById(R.id.spinner);
        String[] operaciones = {"sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.spinner_item_cristian, operaciones);
        sp1.setAdapter(adaptador);

    }

    public void Calcular(View V) {
        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());
        String op = sp1.getSelectedItem().toString();

        if (op.equals("Sumar")) {
            int suma = valor1 + valor2;
            tv1.setText("La suma es: " +suma);

        } else if (op.equals("Restar")) {
            int resta = valor1 - valor2;
            tv1.setText("La resta es: " +resta);

        } else if (op.equals("Multiplicar")) {
            int multiplicar = valor1 * valor2;
            tv1.setText("La Multiplicacion es: " +multiplicar);

        } else if (op.equals("Dividir")) {

            if (valor2 != 0) {
                int dividir = valor1 / valor2;
                tv1.setText("La division es: " +dividir);
            } else {
                Toast.makeText(this, "No se puede dividir entre cero",Toast.LENGTH_LONG).show();
            }
        }
    }
}