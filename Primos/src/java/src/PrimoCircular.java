/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Usuario
 */
public class PrimoCircular {
    
    ArrayList misPrimosConocidos;

    public PrimoCircular() {
        this.misPrimosConocidos = new ArrayList();
    }
    
    public boolean esPrimoCircular(int aVerificar){
            boolean retorno=false;
            boolean porAhora=true;
            
            
            char[] aVerificarChar = String.valueOf(aVerificar).toCharArray();
            ArrayList<char[]> rotaciones=new ArrayList();
            
            for (int i = 0; i < aVerificarChar.length; i++) {
                rotaciones.add(aVerificarChar);
                aVerificarChar = Utilidades.rotarPalabra(aVerificarChar);
            }
            
            for (int i = 0; i < rotaciones.size() && porAhora; i++) {
                int posiblePrimo=Integer.parseInt(String.valueOf(rotaciones.get(i)));
                
                if(!misPrimosConocidos.contains(posiblePrimo)){
                    if(Primos.esPrimo(posiblePrimo)){
                        misPrimosConocidos.add(posiblePrimo);
                    }else{
                        porAhora=false;
                    }
                }
                
            }
                if (porAhora) {
                    retorno=true;
                }
            
        return retorno;
    }

}
