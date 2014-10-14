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
public class buscarPrimosCirculares {
    PrimoCircular primoCircular=new PrimoCircular();
    
    public ArrayList listarPrimosCirculares(int limit){
        ArrayList lista=new ArrayList();

        for (int i = 1; i <= limit; i=i+2) {
            if(primoCircular.esPrimoCircular(i)){
                lista.add(i);
            }
        }
        
        
        return lista;
    }
    

    
    
    
}
