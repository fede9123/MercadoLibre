/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Usuario
 */
public class Primos {
    
    
public static boolean esPrimo(int aVerificar){
    boolean retorno=true;
        
    int i =2;
    
    while(retorno && i<=Math.sqrt(aVerificar)){
        if(aVerificar%i==0){
            retorno=false;
        }
        i++;
    }
    
        
    return retorno;
}
    
}
