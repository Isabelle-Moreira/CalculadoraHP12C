package com.example.calculadorahp12c;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button botaoUm;
    private Button botaoDois;
    private Button botaoTres;
    private Button botaoQuatro;
    private Button botaoCinco;
    private Button botaoSeis;
    private Button botaoSete;
    private Button botaoOito;
    private Button botaoNove;
    private Button botaoPonto;
    private Button Clear;
    private Button Enter;
    calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botaoUm=findViewById(R.id.um);
        botaoDois=findViewById(R.id.dois);
    }
}