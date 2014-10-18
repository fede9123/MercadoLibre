/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Usuario
 */
public class BuscarPrimosCirculares {

    private TreeSet noCircularesConocidos = new TreeSet();
    private TreeSet circularesConocidos = new TreeSet();

    public TreeSet listarPrimosCirculares() {
        long tiempoInicio = System.currentTimeMillis();
        
        PrimoCircular primoCircular = new PrimoCircular();
        circularesConocidos.add(2);
        /*Incremento de a 2, para evitar comprobar números que terminen en numeros pares
         ya que estos no son primos.*/
        for (int numero = 3; numero <= Utilidades.LIMITE; numero = numero + 2) {
            /*Verifico que el número no haya sido verificado previamente, ya que
             puede haber sido comprobada una de sus rotaciones mennores al mismo.*/
            if (!circularesConocidos.contains(numero) && !noCircularesConocidos.contains(numero)) {
                
                ArrayList rotacionesAAgregar = new ArrayList(Utilidades.rotarNumero(numero));
                
                if (primoCircular.esPrimoCircular(numero)) {
                    /*Agrego al número y a sus rotaciones a la lista correspondiente
                     según sean o no primos circulares.
                     Para no volver a verificarlos*/
                    for (int i = 0; i < rotacionesAAgregar.size(); i++) {
                        circularesConocidos.add(rotacionesAAgregar.get(i));
                    }
                } else {
                    for (int i = 0; i < rotacionesAAgregar.size(); i++) {
                        noCircularesConocidos.add(rotacionesAAgregar.get(i));
                    }
                }
            }
        }
        long tiempoFin = System.currentTimeMillis();
        long tiempoDeEjecucion = tiempoFin - tiempoInicio;
        System.out.println("Demora " + tiempoDeEjecucion);
        return circularesConocidos;
    }
}
