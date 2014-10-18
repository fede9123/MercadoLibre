/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Usuario
 */
public class Utilidades {

    public static final int LIMITE = 1000000;
    public static final int THREADS_POOL = 100;

    private static char[] rotarPalabra(char[] palabraChar) {
        char[] palabraCharNueva = new char[palabraChar.length];
        char ultimo = palabraChar[0];
        for (int i = 1; i < palabraChar.length; i++) {
            palabraCharNueva[i - 1] = palabraChar[i];
        }
        palabraCharNueva[palabraChar.length - 1] = ultimo;
        return palabraCharNueva;
    }

    public static ArrayList rotarNumero(int numero) {
         ArrayList listaRotacinoes = new ArrayList();
         char[] palabraChar = String.valueOf(numero).toCharArray();
        for (int j = 0; j < palabraChar.length; j++) {
            if(!listaRotacinoes.contains(Integer.parseInt(String.valueOf(palabraChar)))){
                listaRotacinoes.add(Integer.parseInt(String.valueOf(palabraChar)));
            }
            palabraChar = rotarPalabra(palabraChar);
        }
        return listaRotacinoes;
    }
}
