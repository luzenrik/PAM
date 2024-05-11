package com.android.atividadedoluiznaomexerpfv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nt1, nt2, nt3, nt4, faltas;
    Button calc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nt1 = findViewById(R.id.nota1);
        nt2 = findViewById(R.id.nota2);
        nt3 = findViewById(R.id.nota3);
        nt4 = findViewById(R.id.nota4);

        faltas = findViewById(R.id.numFaltas);

        calc = findViewById(R.id.botaoCalc);

        result = findViewById(R.id.resultado);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(nt1.getText().toString());
                int n2 = Integer.parseInt(nt2.getText().toString());
                int n3 = Integer.parseInt(nt3.getText().toString());
                int n4 = Integer.parseInt(nt4.getText().toString());
                int nFaltas = Integer.parseInt(faltas.getText().toString());

                double media = (n1 + n2 + n3 + n4) / 4;

                boolean retorno = validarCampos();
                if (retorno) {
                    if (media >= 6 && nFaltas <= 20) {
                        result.setText("Aluno foi aprovado com media final " + media);
                        result.setTextColor(getColor(R.color.notaV));
                    } else if (nFaltas > 20) {
                        result.setText("Aluno reprovado por faltas " + faltas);
                        result.setTextColor(getColor(R.color.notaVM));
                    } else if (media < 6) {
                        result.setText("Aluno reprovado por media" + media);
                        result.setTextColor(getColor(R.color.notaVM));
                    } else if (media < 6 && nFaltas > 20) {
                        result.setText("Aluno reprovado por falta e media" + faltas + media);
                        result.setTextColor(getColor(R.color.notaVM));
                    }
                }
            }
        });
    }

    private boolean validarCampos() {
        boolean camposValidados = true;

        if (nt1.getText().toString().isEmpty()) {
            camposValidados = false;
            nt1.setError("Preencha o campo");
        }
        if (nt2.getText().toString().isEmpty()) {
            camposValidados = false;
            nt2.setError("Preencha o campo");
        }
        if (nt3.getText().toString().isEmpty()) {
            camposValidados = false;
            nt3.setError("Preencha o campo");
        }
        if (nt4.getText().toString().isEmpty()) {
            camposValidados = false;
            nt4.setError("Preencha o campo");
        }
        return camposValidados;
    }


}
