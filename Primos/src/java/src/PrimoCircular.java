/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PrimoCircular {

    ArrayList misPrimosConocidos = new ArrayList();
    ArrayList listaPendientes = new ArrayList();

    public boolean esPrimoCircular(int aVerificar) {
        boolean retorno = false;
        boolean porAhora = true;

        if (aVerificar > 1 && aVerificar <= Utilidades.LIMITE) {
            /*El 2 y el 5 los trato diferente para no descartarlo en los métodos
             contieneCifraPar o  contieneCifraCinco.*/
            if (aVerificar != 2
                    && aVerificar != 5) {
                /*Busco todas las rotaciones del número a verificar*/
                ArrayList rotaciones = Utilidades.rotarNumero(aVerificar);
                /*Si contiene alguna cifra par, ya no es primo circular, evito verificaciones*/
                if (!contieneCifraPar(aVerificar)) {
                    /*Si contiene alguna cifra 5, ya no es primo circular, evito verificaciones*/
                    if (!contieneCifraCinco(aVerificar)) {
                        /*Busco todas las rotaciones del número a verificar*/
                        for (int i = 0; i < rotaciones.size(); i++) {
                            if (!misPrimosConocidos.contains(rotaciones.get(i))) {
                                listaPendientes.add(rotaciones.get(i));
                            }
                        }
                        /*Creo la lista de hilos a correr en paralelo*/
                        Collection<Callable<Integer>> hilos = new ArrayList(listaPendientes.size());
                        for (int i = 0; i < listaPendientes.size(); i++) {
                            hilos.add(new Primos((int) listaPendientes.get(i)));
                        }
                        ExecutorService ejecutor = new ScheduledThreadPoolExecutor(Utilidades.THREADS_POOL);
                        // Ejecuto todos los hilos y espero por sus resultados.
                        List<Future<Integer>> results = null;
                        try {
                            System.out.println("Largo a correr " + hilos.size() + " hilos.");
                            results = ejecutor.invokeAll(hilos);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PrimoCircular.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (Future<Integer> future : results) {
                            try {
                                if (future.get() == 0) {
                                    porAhora = false;
                                } else {
                                    misPrimosConocidos.add(future.get().intValue());
                                }
                            } catch (InterruptedException | ExecutionException ex) {
                                Logger.getLogger(PrimoCircular.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        listaPendientes.clear();
                        ejecutor.shutdown();
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

    public boolean contieneCifraPar(int aVerificar) {
        char[] palabraChar = String.valueOf(aVerificar).toCharArray();
        boolean retorno = false;
        for (int i = 0; i < palabraChar.length && !retorno; i++) {
            if (palabraChar[i] % 2 == 0) {
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean contieneCifraCinco(int aVerificar) {
        char[] palabraChar = String.valueOf(aVerificar).toCharArray();
        boolean retorno = false;
        for (int i = 0; i < palabraChar.length && !retorno; i++) {
            if (Integer.parseInt(String.valueOf(palabraChar[i])) == 5) {
                retorno = true;
            }
        }
        return retorno;
    }
}
