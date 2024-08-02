package com.example.calculadorahp12c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button botaoZero;
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
    private Button botaoDivisao;
    private Button botaoMultiplicacao;
    private Button botaoSubtracao;
    private Button botaoSoma;
    private EditText Visor;
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
        botaoZero= findViewById(R.id.zero);
        botaoUm=findViewById(R.id.um);
        botaoDois=findViewById(R.id.dois);
        botaoTres=findViewById(R.id.tres);
        botaoQuatro=findViewById(R.id.quatro);
        botaoCinco=findViewById(R.id.cinco);
        botaoSeis=findViewById(R.id.seis);
        botaoSete=findViewById(R.id.sete);
        botaoOito=findViewById(R.id.oito);
        botaoNove=findViewById(R.id.nove);
        botaoPonto=findViewById(R.id.ponto);
        Clear=findViewById(R.id.clear);
        Enter = findViewById(R.id.enter);
        Visor = findViewById(R.id.visor);
        botaoDivisao = findViewById(R.id.divisao);
        botaoMultiplicacao = findViewById(R.id.multiplicacao);
        botaoSubtracao = findViewById(R.id.subtracao);
        botaoSoma = findViewById(R.id.soma);



        botaoZero.setOnClickListener(ClicaNumero("0"));
        botaoUm.setOnClickListener(ClicaNumero("1"));
        botaoDois.setOnClickListener(ClicaNumero("2"));
        botaoTres.setOnClickListener(ClicaNumero("3"));
        botaoQuatro.setOnClickListener(ClicaNumero("4"));
        botaoCinco.setOnClickListener(ClicaNumero("5"));
        botaoSeis.setOnClickListener(ClicaNumero("6"));
        botaoSete.setOnClickListener(ClicaNumero("7"));
        botaoOito.setOnClickListener(ClicaNumero("8"));
        botaoNove.setOnClickListener(ClicaNumero("9"));
        botaoPonto.setOnClickListener(ClicaNumero("."));


        Visor.setShowSoftInputOnFocus(false);

        Clear.setOnClickListener(v -> {
            if(Visor.getSelectionStart()!=0) {
                int inicioSelecao = Visor.getSelectionStart() - 1;
                int finalSelecao = Visor.getSelectionEnd();
                Visor.getText().delete(inicioSelecao, finalSelecao);
            }
        });

        calculadora = new calculadora();

        Enter.setOnClickListener(v -> {
            calculadora.enter();
            Visor.setText(" ");
        });

        botaoDivisao.setOnClickListener(ClicaDivisao());
        botaoMultiplicacao.setOnClickListener(ClicaMultiplicacao());
        botaoSubtracao.setOnClickListener(ClicaSubtracao());
        botaoSoma.setOnClickListener(ClicaSoma());





        }



    public View.OnClickListener ClicaNumero(String numero){
        return(v) ->{
            if(calculadora.estadoAtual==calculadora.visualizando){
                Visor.setText(" ");
            }
           if(Visor.getText().toString().contains(".")&& numero.equals(".")) {
               return;
           }

            Visor.getText().append(numero);
            calculadora.setValores(numero);
        };
    }

    public View.OnClickListener ClicaDivisao(){
        return(v) ->{
            calculadora.divisao();
            Visor.setText( String.valueOf(calculadora.getValorVisualizado()));
        };
    }

    public View.OnClickListener ClicaMultiplicacao(){
        return(v) ->{
            calculadora.multiplicacao();
            Visor.setText( String.valueOf(calculadora.getValorVisualizado()));
        };
    }

    public View.OnClickListener ClicaSubtracao(){
        return(v) ->{
            calculadora.subtracao();
            Visor.setText( String.valueOf(calculadora.getValorVisualizado()));
        };
    }

    public View.OnClickListener ClicaSoma(){
        return(v) ->{
            calculadora.soma();
            Visor.setText( String.valueOf(calculadora.getValorVisualizado()));
        };
    }












}