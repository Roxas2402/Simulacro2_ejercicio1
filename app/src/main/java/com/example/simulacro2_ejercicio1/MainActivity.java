package com.example.simulacro2_ejercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TextView txtCigarros;
    private TextView txtDinero;
    private Button btnFumar;
    private int numCigarros = 20;
    private int dineros = 0;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializa();
        btnFumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (numCigarros <= 20) {
                    numCigarros -= 1;
                    txtCigarros.setText(getString(R.string.num_cigarros) + numCigarros);
                    txtDinero.setText(getString(R.string.dinero_ahorrado) + nf.format(dineros));
                }

                if (numCigarros == 0) {
                    numCigarros = 20;
                    dineros += 5;
                    txtCigarros.setText(getString(R.string.num_cigarros) + numCigarros);
                    txtDinero.setText(getString(R.string.dinero_ahorrado) + nf.format(dineros));
                }

            }
        });

    }

    private void inicializa() {
        txtCigarros = findViewById(R.id.txtCigarrosRestantesMain);
        txtDinero = findViewById(R.id.txtDineroMain);
        btnFumar = findViewById(R.id.btnFumar);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CIGARROS", numCigarros);
        outState.putInt("DINEROS", dineros);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numCigarros = savedInstanceState.getInt("CIGARROS");
        dineros=savedInstanceState.getInt("DINEROS");
        txtCigarros.setText(getString(R.string.num_cigarros) + String.valueOf(numCigarros));
        txtDinero.setText(getString(R.string.dinero_ahorrado) + String.valueOf(dineros));
    }
}