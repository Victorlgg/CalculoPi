/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;

/**
 *
 * @author RGH-LS24-16
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static BigDecimal pi = new BigDecimal(BigInteger.ZERO, MathContext.UNLIMITED);
    static int Contador=0;
    
    public static void main(String[] args) throws InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
//        int x = 5000000;
        final long startTime = System.currentTimeMillis();
        proceso threads[] = new proceso[2];
        threads[0] =new proceso("Proceso1", 1, (x / 2));
        threads[1] =new proceso("Proceso2", (x / 2) + 1, x);
        
        threads[0].start();
        threads[1].start();
        
        for (int i = 0; i < 2; i++) {
            threads[i].join();
            pi  = pi.add(threads[i].sumarPi());
        }
         final long endTime = System.currentTimeMillis();
        pi=pi.add(BigDecimal.ONE);
        pi=pi.multiply(BigDecimal.valueOf(4));
        System.out.printf("Resultado = %3.100f \nTiempo: %s\n", pi,
                (endTime - startTime) / 1000.0);
        


    }

}


/*Util multihilo
https://gomezh.dev/2015/08/24/java-pi-threads
for (int i = 0; i < CPU_CORES; i++) {
            long start = i * NUM_RECTS / CPU_CORES;
            long end = (i + 1) * NUM_RECTS / CPU_CORES;

            threads[i] = new PIThread(start, end, width);
            threads[i].start(); // Start computation
        }




*/