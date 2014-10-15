/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class BuscarPrimosCirculares {

    PrimoCircular primoCircular = new PrimoCircular();

    public ArrayList listarPrimosCirculares(int limite) {
        ArrayList lista = new ArrayList();
        lista.add(2);
        for (int i = 3; i <= limite; i = i + 2) {
            if (primoCircular.esPrimoCircular(i)) {
                lista.add(i);
            }
        }

        return lista;
    }

}
