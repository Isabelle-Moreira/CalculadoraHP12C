package com.example.calculadorahp12c;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayDeque;
public class calculadoraTest {
    private calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new calculadora();
    }

    @Test
    public void testSoma() {
        calculadora.setValores("5");
        calculadora.enter();
        calculadora.setValores("3");
        calculadora.enter();
        calculadora.soma();
        assertEquals(8.0, calculadora.getValorVisualizado(), 0.001);
    }

    @Test
    public void testSubtracao() {
        calculadora.setValores("10");
        calculadora.enter();
        calculadora.setValores("4");
        calculadora.enter();
        calculadora.subtracao();
        assertEquals(6.0, calculadora.getValorVisualizado(), 0.001);
    }

    @Test
    public void testMultiplicacao() {
        calculadora.setValores("2");
        calculadora.enter();
        calculadora.setValores("6");
        calculadora.enter();
        calculadora.multiplicacao();
        assertEquals(12.0, calculadora.getValorVisualizado(), 0.001);
    }

    @Test
    public void testDivisao() {
        calculadora.setValores("15");
        calculadora.enter();
        calculadora.setValores("3");
        calculadora.divisao();
        assertEquals(5.0, calculadora.getValorVisualizado(), 0.001);
    }

    @Test
    public void testDivisaPorZero() {
        calculadora.setValores("5");
        calculadora.enter();
        calculadora.setValores("0");
        calculadora.divisao();
        assertEquals(0.0, calculadora.getValorVisualizado(), 0.001);
    }

    @Test
    public void testSomatres() {
        calculadora.setValores("2");
        calculadora.enter();
        calculadora.setValores("2");
        calculadora.enter();
        calculadora.setValores("2");
        calculadora.soma();
        calculadora.soma();
        assertEquals(6.0, calculadora.getValorVisualizado(), 0.001);
    }



}
