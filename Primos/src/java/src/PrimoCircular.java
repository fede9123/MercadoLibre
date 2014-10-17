/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Usuario
 */
public class PrimoCircular extends Thread {

    private int aVerficar;
    BuscarPrimosCirculares buscador;
    public PrimoCircular(int aVerficar, BuscarPrimosCirculares buscador) {
        this.aVerficar=aVerficar;
        this.buscador=buscador;
    }
    
    @Override
    public void run() {
        if(esPrimoCircular(aVerficar)){
            buscador.getLista().add(aVerficar);
            char[] aAgregar = String.valueOf(aVerficar).toCharArray();
                for (int j = 0; j < aAgregar.length; j++) {
                    buscador.getLista().add(Integer.parseInt(String.valueOf(aAgregar)));
                    aAgregar = Utilidades.rotarPalabra(aAgregar);
            }
        }
    }

    public boolean esPrimoCircular(int aVerificar) {
        boolean retorno = false;
        boolean porAhora = true;

        if (aVerificar > 1 && aVerificar <= Utilidades.LIMITE) {
            /*El 2 y el 5 los trato diferente para no descartarlo en los métodos
             contieneCifraPar o  contieneCifraCinco.*/
            if (aVerificar != 2
                    && aVerificar != 5) {

                char[] aVerificarChar = String.valueOf(aVerificar).toCharArray();
                ArrayList<char[]> rotaciones = new ArrayList();

                /*Si contiene alguna cifra par, ya no es primo circular, evito verificaciones*/
                if (!contieneCifraPar(aVerificarChar)) {
                    /*Si contiene alguna cifra 5, ya no es primo circular, evito verificaciones*/
                    if (!contieneCifraCinco(aVerificarChar)) {
                        /*Busco todas las rotaciones del número a verificar*/
                        for (int i = 0; i < aVerificarChar.length; i++) {
                            if (!rotaciones.contains(aVerificarChar)) {
                                rotaciones.add(aVerificarChar);
                            }
                            aVerificarChar = Utilidades.rotarPalabra(aVerificarChar);
                        }
                        /*Verifico que cada rotacion sea número primo*/
                        for (int i = 0; i < rotaciones.size() && porAhora; i++) {
                            int posiblePrimo = Integer.parseInt(String.valueOf(rotaciones.get(i)));
                            
                            if (!buscador.getPrimosConocidos().contains(posiblePrimo)) {
                                if (Primos.esPrimo(posiblePrimo)) {     
                                    buscador.getPrimosConocidos().add(posiblePrimo);
                                } else {
                                    porAhora = false;
                                }
                            }
                        }
                    } else {
                        porAhora = false;
                    }
                } else {
                    porAhora = false;
                }
            }
        } else {
            porAhora = false;
        }

        if (porAhora) {
            retorno = true;
        }
        return retorno;
    }

    public boolean contieneCifraPar(char[] aVerificar) {
        boolean retorno = false;
        for (int i = 0; i < aVerificar.length && !retorno; i++) {
            if (aVerificar[i] % 2 == 0) {
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean contieneCifraCinco(char[] aVerificar) {
        boolean retorno = false;
        for (int i = 0; i < aVerificar.length && !retorno; i++) {
            if (Integer.parseInt(String.valueOf(aVerificar[i])) == 5) {
                retorno = true;
            }
        }
        return retorno;
    }
}
