package com.example.calculadorahp12c;
import java.util.Deque;
import java.util.Optional;
import java.util.function.BiFunction;

public class calculadora /*extends AppCompatActivity*/{

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        operandos = new ArrayDeque<>();
    }*/


    private Deque<Double> operandos;
    private static final int editando = 0;
    private static final int visualizando = 1;
    private int estadoAtual;
    private String valorVisualizado;


    public calculadora(){
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

    public void enter() {
        if (estadoAtual == editando) {
            operandos.push(Double.parseDouble(valorVisualizado));
            estadoAtual = visualizando;
        }
    }
     public void executarOperacao(BiFunction<Double, Double,Double>operacao){
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
                System.err.println("Erro: Divisão por zero!");
            }
        }
    }

}






