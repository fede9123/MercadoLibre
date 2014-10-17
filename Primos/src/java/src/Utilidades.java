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
public class Utilidades {
    public static final int LIMITE=100000000;
    
    
    public static char[] rotarPalabra(char[] palabraChar){
        char[] palabraCharNueva=new char[palabraChar.length];
        char ultimo=palabraChar[0];
        
        for (int i = 1; i < palabraChar.length; i++) {
                palabraCharNueva[i-1]=palabraChar[i];
        }
        
        palabraCharNueva[palabraChar.length-1]=ultimo;
        
        return palabraCharNueva;
    }
}
