/**
 *
 * @author elena
 */

package probando;

import java.util.ArrayList;

public class copia {
    private ArrayList<numero> numeros;
    
    public copia(){
        numeros= new ArrayList();
    }
    
    public void add(numero i){
        numeros.add(i);
    }
    
    ArrayList<numero> getNumeros(){
        return numeros;
    }
    
    void show_elements(){
        for(numero n: numeros)
            System.out.println(n);
    }
}
