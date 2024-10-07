package com.example.calculadoraidade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


/*
 *@author:<Brenda Santana>
 *@ra:<1110482313042>
 */
public class MainActivity extends AppCompatActivity {

    private EditText editTextDia, editTextMes, editTextAno;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDia = findViewById(R.id.editTextDia);
        editTextMes = findViewById(R.id.editTextMes);
        editTextAno = findViewById(R.id.editTextAno);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIdade();
            }
        });
    }

    private void calcularIdade() {
        int diaNasc = Integer.parseInt(editTextDia.getText().toString());
        int mesNasc = Integer.parseInt(editTextMes.getText().toString()) - 1;
        int anoNasc = Integer.parseInt(editTextAno.getText().toString());

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(anoNasc, mesNasc, diaNasc);

        Calendar dataAtual = Calendar.getInstance();

        int anos = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        int meses = dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH);
        int dias = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH);

        if (dias < 0) {
            meses--;
            dias += dataNascimento.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        if (meses < 0) {
            anos--;
            meses += 12;
        }

        textViewResultado.setText(String.format("Idade: %d anos, %d meses, %d dias", anos, meses, dias));
    }
}
