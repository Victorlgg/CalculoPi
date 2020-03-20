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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ingrese el numero de iteraciones");
        Scanner sc = new Scanner(System.in);
        int iteraciones = sc.nextInt();
        System.out.println("Ingrese el numero de hilos");
        int cantidad_hilos = sc.nextInt();
        proceso threads[] = new proceso[cantidad_hilos];//Crea los hilos con la cantidad dada
        System.out.println("Ingrese el numero de decimales");
        int decimales = sc.nextInt();

        //Mide el tiempo de inicio de ejecución    
        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < cantidad_hilos; i++) {
            int start = i * (iteraciones / cantidad_hilos);//inicio del ciclo del hilo
            if (i == 0) { start += 1; }//Para que no empiece en cero, si se borra sale 7.14 como pi
            int end = (i + 1) * (iteraciones / cantidad_hilos) + 1;//fin del ciclo del hilo
            threads[i] = new proceso("Proceso" + i, start, end, decimales);//nombre,inicio, fin, y decimales seleccionados
            threads[i].start(); // Inicio del hilo
        }
        
        //Esperar que terminen los hilos para sumar el resultado
        for (int i = 0; i < cantidad_hilos; i++) {
            threads[i].join();
            pi = pi.add(threads[i].sumarPi());
        }
        
        //Mide el tiempo final de ejecucion
        final long endTime = System.currentTimeMillis();
        
//      Realizo manualmente las dos operaciones que faltan
        pi = pi.add(BigDecimal.ONE);
        pi = pi.multiply(BigDecimal.valueOf(4));
        
        //Imprimo el resultado con decimales seleccionados y el tiempo de ejecución
        System.out.printf("Resultado = %3." + decimales + "f \nTiempo: %s\n", pi,
                (endTime - startTime) / 1000.0);

    }

}


