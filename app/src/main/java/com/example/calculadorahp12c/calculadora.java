package com.example.calculadorahp12c;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayDeque;
import java.util.Deque;

public class calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        operandos = new ArrayDeque<>();
    }

    private Deque<Double> operandos;
    private static final int editando = 0;
    private static final int visualizando = 1;
    private int estadoAtual;
    private double valorVisualizado;


    public double getValorVisualizado() {
        return valorVisualizado;
    }

    public void enter() {
        if (estadoAtual == editando) {
            operandos.push((double) valorVisualizado);
            estadoAtual = visualizando;
        }
    }

    public void soma() {
        if (estadoAtual == editando) {
            enter();
        }
        if (operandos.size() >= 2) {
            double operando2 = operandos.pop();
            double operando1 = operandos.pop();
            double resultado = operando1 + operando2;
            operandos.push(resultado);
            valorVisualizado = (int) resultado;
            estadoAtual = visualizando;
        }
    }

    public void subtracao() {
        if (estadoAtual == editando) {
            enter();
        }
        if (operandos.size() >= 2) {
            double operando2 = operandos.pop();
            double operando1 = operandos.pop();
            double resultado = operando1 - operando2;
            operandos.push(resultado);
            valorVisualizado = (int) resultado;
            estadoAtual = visualizando;
        }
    }

    public void multiplicacao() {
        if (estadoAtual == editando) {
            enter();
        }
        if (operandos.size() >= 2) {
            double operando2 = operandos.pop();
            double operando1 = operandos.pop();
            double resultado = operando1 * operando2;
            operandos.push(resultado);
            valorVisualizado = (int) resultado;
            estadoAtual = visualizando;
        }
    }

    public void divisao() {
        if (estadoAtual == editando) {
            enter();
        }
        if (operandos.size() >= 2) {
            double operando2 = operandos.pop();
            double operando1 = operandos.pop();
            if (operando2 != 0) { // Proteção contra divisão por zero
                double resultado = operando1 / operando2;
                operandos.push(resultado);
                valorVisualizado = (int) resultado;
                estadoAtual = visualizando;
            } else {
                System.err.println("Erro: Divisão por zero!");
            }
        }
    }

}
