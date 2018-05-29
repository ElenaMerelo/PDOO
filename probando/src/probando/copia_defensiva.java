/**
 *
 * @author elena
 */

package probando;

import java.util.ArrayList;

class copia_defensiva {
    private ArrayList<numero> numeros;
    
    public copia_defensiva(){
        numeros= new ArrayList();
    }
    
    public void add(numero i){
        numeros.add(i);
    }
    
    ArrayList<numero> getNumeros(){
        return (ArrayList<numero>) numeros.clone(); //se hace el casting porque clone es de la clase Object
    }
    
    void show_elements(){
        for(numero n: numeros)
            System.out.println(n);
    }
}
