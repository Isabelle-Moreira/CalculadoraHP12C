package com.example.calculadorahp12c;
import androidx.lifecycle.ViewModel;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Optional;
import java.util.function.BiFunction;

public class Calculadora extends ViewModel {

    private Deque<Double> operandos;
    public static final int editando = 0;
    public static final int visualizando = 1;
    public int estadoAtual;
    private String valorVisualizado;
    public double PV;
    public double PMT;
    public double FV;
    public double i;
    public double n;


    public Calculadora(){
        PV=0;
        PMT=1;
        FV=0;
        i =0;
        n= 1;
        operandos = new ArrayDeque<>();
        estadoAtual =visualizando;
        valorVisualizado="2";
    }

    public void setValores(String valor) {
        if(estadoAtual==visualizando){
            valorVisualizado ="";
        }
        estadoAtual=editando;
        valorVisualizado+=valor;
    }

    public double getValorVisualizado() {
        return Double.parseDouble(valorVisualizado);
    }

    public void inserePv(){
        if(estadoAtual==editando){
            PV = Double.parseDouble(valorVisualizado);
            estadoAtual=visualizando;
        }else {
            CalculaPV();
        }
    }
    public void insereFv(){
        if(estadoAtual==editando){
            FV = Double.parseDouble(valorVisualizado);
            estadoAtual=visualizando;
        }else{
            CalculaFV();
        }
    }
    public void insereI(){
        if(estadoAtual==editando){
            i = Double.parseDouble(valorVisualizado);
            estadoAtual=visualizando;
        }else{
            CalculaI();
        }
    }
    public void insereN(){
        if(estadoAtual==editando){
            n = Double.parseDouble(valorVisualizado);
            estadoAtual=visualizando;
        }else {
            CalculaN();
        }
    }
    public void inserePmt(){
        if(estadoAtual==editando){
            PMT = Double.parseDouble(valorVisualizado);
            estadoAtual=visualizando;
        }else{
            CalculaPMT();
        }
    }

    public void CalculaPV(){
        PV = (FV / Math.pow((1+i),n));
        valorVisualizado = Double.toString(PV);
    }
    public void CalculaPMT(){
        PMT = PV*((Math.pow((1+i),n)*i)/(Math.pow((1+i),n)-1));
        valorVisualizado = Double.toString(PMT);
    }

    public void CalculaFV(){
        FV = ( PV * Math.pow((1+i),n));
        valorVisualizado = Double.toString(FV);
    }
    public void CalculaI(){
        i = (Math.pow((FV / PV), (1.0 / n)) - 1);
        valorVisualizado = Double.toString(i);
    }
    public void CalculaN(){
        n = (Math.log(FV / PV) / Math.log(1 + i));
        valorVisualizado = Double.toString(n);
    }

    public void enter() {
        if (estadoAtual == editando) {
            operandos.push(Double.parseDouble(valorVisualizado));
            estadoAtual = visualizando;
        }
    }
     public void executarOperacao(BiFunction<Double, Double,Double>operacao){
         if(estadoAtual==editando){
             enter();
         }
         double operando2 = Optional.ofNullable(operandos.pollFirst()).orElse(0.0);
         double operando1 = Optional.ofNullable(operandos.pollFirst()).orElse(0.0);
         double resultado = operacao.apply(operando1,operando2);
         operandos.push(resultado);
         valorVisualizado =  String.valueOf(resultado);
         estadoAtual = visualizando;
     }


    public void soma() {
        executarOperacao((operando1,operando2)-> operando1+operando2);
    }

    public void subtracao() {

        executarOperacao((operando1,operando2)-> operando1-operando2);
    }

    public void multiplicacao() {
        executarOperacao((operando1,operando2)-> operando1*operando2);
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
                valorVisualizado = String.valueOf(resultado);
                estadoAtual = visualizando;
            } else {
                    operandos.push(operando1);
                    operandos.push(operando2);
                System.err.println("Erro: Divisão por zero!");
                valorVisualizado ="0";
            }
        }
    }

}






