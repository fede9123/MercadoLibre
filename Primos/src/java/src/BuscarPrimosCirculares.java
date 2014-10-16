/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.TreeSet;

/**
 *
 * @author Usuario
 */
public class BuscarPrimosCirculares {

    PrimoCircular primoCircular = new PrimoCircular();

    public TreeSet listarPrimosCirculares(int limite) {
        TreeSet lista = new TreeSet();
        lista.add(2);
        for (int i = 3; i <= limite; i = i + 2) {
            if (!lista.contains(i) && primoCircular.esPrimoCircular(i)) {
                /*Si es primo circular, lo agrego a el y a sus rotaciones 
                 para no volver a verificarlas*/
                char[] aAgregar = String.valueOf(i).toCharArray();
                for (int j = 0; j < aAgregar.length; j++) {
                    lista.add(Integer.parseInt(String.valueOf(aAgregar)));
                    aAgregar = Utilidades.rotarPalabra(aAgregar);
                }
            }
        }
        return lista;
    }

}