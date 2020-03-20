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
 * @author Victor Galindo
 */
public class Principal {

    static BigDecimal pi = new BigDecimal(BigInteger.ZERO, MathContext.UNLIMITED);
    static int Contador=0;
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ingrese el numero de iteraciones");
        Scanner sc = new Scanner(System.in);
        int iteraciones = sc.nextInt();
//        int iteraciones = 5000000;
	System.out.println("Ingrese el numero de hilos");
	int cantidad_hilos = sc.nextInt();
        proceso threads[] = new proceso[cantidad_hilos];
        System.out.println("Ingrese el numero de decimales");
        int decimales= sc.nextInt();

        final long startTime = System.currentTimeMillis();

	for (int i = 0; i < cantidad_hilos; i++) {
            int start = i * (iteraciones/cantidad_hilos);
            if(i==0){ start+=1;}//Para que no empiece en cero, si se borra sale 7.14 como pi
            int end = (i + 1) * (iteraciones / cantidad_hilos) + 1;
            threads[i] = new proceso("Proceso"+i, start, end, decimales);
            threads[i].start(); // Start computation
        }	
	
	for (int i = 0; i < cantidad_hilos; i++) {
            threads[i].join();
            pi  = pi.add(threads[i].sumarPi());
        }



//      proceso threads[] = new proceso[2];
//      threads[0] =new proceso("Proceso1", 1, (iteraciones / 2));
//      threads[1] =new proceso("Proceso2", (iteraciones / 2) + 1, iteraciones);
//        
//        threads[0].start();
//        threads[1].start();
////        
//        for (int i = 0; i < 2; i++) {
//            threads[i].join();
//            pi  = pi.add(threads[i].sumarPi());
//        }


         final long endTime = System.currentTimeMillis();
        pi=pi.add(BigDecimal.ONE);
        pi=pi.multiply(BigDecimal.valueOf(4));
        System.out.printf("Resultado = %3."+decimales+"f \nTiempo: %s\n", pi,
                (endTime - startTime) / 1000.0);
        
        /** Para mirar si los hilos se detuvieron  */
//        for(int i=0;i<threads.length;i++){
//        System.out.println("Hilo "+i+" : "+threads[i].isInterrupted());
//        }
        


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