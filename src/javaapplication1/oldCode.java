/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author RGH-LS24-16
 */
public class oldCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Thread hilo = new proceso("Proceso1",1);
//        Thread hilo2 = new proceso("proceso2",0);
        final long startTime = System.currentTimeMillis();
        
        BigDecimal pi = new BigDecimal(BigInteger.ONE, MathContext.UNLIMITED);
        BigDecimal i = new BigDecimal(new BigInteger("1"), MathContext.UNLIMITED);

//        BigDecimal j = new BigDecimal(new BigInteger("3"),MathContext.UNLIMITED);
        BigDecimal TWO = new BigDecimal("2");
//        BigDecimal ONE = new BigDecimal("1");
//        int i=2;
//        int j=3;

        while (i.longValue() < 5000000) {
//        pi = pi.add(BigDecimal.valueOf(Math.pow(-1, i) / (2 * i + 1)));
            
                pi = pi.add(BigDecimal.ONE.negate().pow(i.intValue()).divide((i.multiply(TWO).add(BigDecimal.ONE)), 100, BigDecimal.ROUND_UP));
                i =i.add(BigDecimal.ONE);
//                System.out.println(i.intValue() +" Resta: "+pi.toPlainString());
//                System.out.println(""+BigDecimal.ONE.negate().pow(i.intValue()).divide((i.multiply(TWO).add(BigDecimal.ONE)), 999, BigDecimal.ROUND_DOWN));
            
//            System.out.println(""+pi.multiply(BigDecimal.valueOf(4)));
//        pi = pi.add(BigDecimal.valueOf(Math.pow(-1, i) / (2 * i + 1)));
//        pi = pi.subtract(BigDecimal.valueOf(Math.pow(1,1)/(2*i - 1)));
//        pi = pi.add(BigDecimal.valueOf(Math.pow(1,1)/(2*j - 1)));
//        i+=2;        
        }
        
pi = pi.multiply(BigDecimal.valueOf(4));
                System.out.println(pi.toPlainString());
              final long endTime = System.currentTimeMillis();
                System.out.printf("Resultado = %3.100f, Tiempo: %s\n", pi,
                (endTime - startTime) / 1000.0);
//        System.out.println(pi.toString());
//        double pie=0;
//        for(double x=2, j=3; x<1000000000.0;x+=8,j+=8){
//            pie-=1/(2*x-1)+ 1/(2*(x+2)-1) + 1/(2*(x+4)-1) + 1/(2*(x+6)-1);
//            pie+=1/(2*j-1) + 1/(2*(j+2)-1)+ 1/(2*(j+4)-1) + 1/(2*(j+6)-1);
//        }
//        pie+=1;
//        pie*=4;
//        System.out.printf(" %3.22f",pie);



        //solucion en ingles
        //BigDecimal toString()
        //unscaled val, math context
        //ram
//        System.out.println(Double.MAX_VALUE);
    }
    
    

}
