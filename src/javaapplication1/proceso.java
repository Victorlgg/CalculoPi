/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication1.Principal.pi;
import static javaapplication1.Principal.Contador;


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
    
    public proceso(String msg, int inicio, int fin, int decimales) {
        super(msg);
        this.inicio = inicio;
        this.fin = fin;
        this.decimales = decimales;

    }
    
    public BigDecimal sumarPi(){
        return sumas;
    }
    
    public synchronized void calcularPi(){
        BigDecimal i = new BigDecimal(new BigInteger(String.valueOf(inicio)), MathContext.UNLIMITED);
        
//        while (i.longValue() <= fin) {
            while(i.compareTo(BigDecimal.valueOf(fin))<=0){
//                Contador+=1;
//            sumas = sumas.add(BigDecimal.ONE.negate().pow(i.intValue()).divide((i.multiply(TWO).add(BigDecimal.ONE)), 100, BigDecimal.ROUND_HALF_EVEN));
            sumas = sumas.add(BigDecimal.ONE.negate().pow(i.intValue()).divide((i.multiply(TWO).add(BigDecimal.ONE)), decimales, BigDecimal.ROUND_HALF_EVEN));
            i = i.add(BigDecimal.ONE);
//                System.out.println(Thread.currentThread().getName()+" _ "+pi.multiply(BigDecimal.valueOf(4)).toPlainString());
    
        }
//        System.out.println(i.longValue()+"xd "+ Contador+" "+Thread.currentThread().getName() + " _ " + sumas.toPlainString());
    }

    public void run() {

        calcularPi();
    }

}
