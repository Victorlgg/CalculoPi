/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
//import static javaapplication1.Principal.pi;
//import static javaapplication1.Principal.Contador;

/**
 *
 * @author Victor
 */
public class proceso extends Thread {

    int inicio, fin;
    int decimales;
    String msg;
    BigDecimal TWO = new BigDecimal("2");
    BigDecimal sumas = new BigDecimal(BigInteger.ZERO, MathContext.UNLIMITED);

    public proceso(String nombre, int inicio, int fin, int decimales) {
        super(nombre);
        this.inicio = inicio;
        this.fin = fin;
        this.decimales = decimales;

    }

    public BigDecimal sumarPi() {
        return sumas;
    }

    public synchronized void calcularPi() {
        BigDecimal i = new BigDecimal(new BigInteger(String.valueOf(inicio)), MathContext.UNLIMITED);

        while (i.compareTo(BigDecimal.valueOf(fin)) <= 0) {
            //Formula de Leibniz
            sumas = sumas.add(BigDecimal.ONE.negate().pow(i.intValue()).divide((i.multiply(TWO).add(BigDecimal.ONE)), decimales, BigDecimal.ROUND_HALF_EVEN));
            i = i.add(BigDecimal.ONE);
            //Para imprimir el hilo y el valor de pi actual
//                System.out.println(Thread.currentThread().getName()+" _ "+pi.multiply(BigDecimal.valueOf(4)).toPlainString());

        }
    }

    public void run() {
        calcularPi();
    }

}
