/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class BuscarPrimosCirculares {

    private TreeSet primosConocidos = new TreeSet();
    private TreeSet lista = new TreeSet();

    public synchronized TreeSet getPrimosConocidos() {
        return primosConocidos;
    }

    public synchronized TreeSet getLista() {
        return lista;
    }

    public TreeSet listarPrimosCirculares(int limite) {
            long startTime = System.currentTimeMillis();
            
            lista.add(2);
            for (int numero = 3; numero <= limite; numero = numero + 2) {
                if (!lista.contains(numero)) {
                    PrimoCircular primoCircular = new PrimoCircular(numero , this);
                    primoCircular.start();
                }
    //                /*Si es primo circular, lo agrego a el y a sus rotaciones 
    //                 para no volver a verificarlas*/
    //                char[] aAgregar = String.valueOf(numero).toCharArray();
    //                for (int j = 0; j < aAgregar.length; j++) {
    //                    lista.add(Integer.parseInt(String.valueOf(aAgregar)));
    //                    aAgregar = Utilidades.rotarPalabra(aAgregar);
    //            }
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Demora "+elapsedTime);
            return lista;
    }

}