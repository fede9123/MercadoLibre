/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.concurrent.Callable;

/**
 *
 * @author Usuario
 */
public class Primos implements Callable<Integer> {

    private int aVerificar;

    public Primos(int aVerificar) {
        this.aVerificar = aVerificar;
    }

    @Override
    public Integer call() {
        System.out.println("Verifico " + aVerificar);
        boolean esPrimo = true;
        int i = 2;
        while (esPrimo && i <= Math.sqrt(aVerificar)) {
            if (aVerificar % i == 0) {
                esPrimo = false;
            }
            i++;
        }
        if (esPrimo) {
            return aVerificar;
        } else {
            return 0;
        }
    }

    public static boolean esPrimo(int aVerificar) {
        System.out.println("Verifico " + aVerificar);
        boolean retorno = true;
        int i = 2;
        while (retorno && i <= Math.sqrt(aVerificar)) {
            if (aVerificar % i == 0) {
                retorno = false;
            }
            i++;
        }
        return retorno;
    }
}
