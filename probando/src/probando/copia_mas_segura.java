/**
 *
 * @author elena
 */

package probando;

import java.util.ArrayList;

class copia_mas_segura implements Cloneable {
    private ArrayList<numero_v2> numeros;
    private static int cuenta= 0;
    
    public copia_mas_segura(){
        numeros= new ArrayList();
        copia_mas_segura.otraInstancia();
    }
    
    public void add(numero_v2 i){
        numeros.add(i);
    }
    
    public static void otraInstancia(){ cuenta++; }
    
    public static int getInstancias(){ return cuenta; }
    
    ArrayList<numero_v2> getNumeros(){
        ArrayList<numero_v2> nuevo= new ArrayList();
        numero_v2 n= null;
        
        for(numero_v2 i: numeros){
            try { n= i.clone(); }
            catch (CloneNotSupportedException e){ System.err.println("CloneNotSupportedException");}
            nuevo.add(n);
        }
        
        return nuevo;
    }
    
    void show_elements(){
        for(numero_v2 n: numeros)
            System.out.println(n);
    }
    
    @Override 
    public copia_mas_segura clone () throws CloneNotSupportedException {
        copia_mas_segura nueva= (copia_mas_segura) super.clone();
        nueva.numeros= this.getNumeros(); //podemos usar getNumeros() porque realiza copia profunda
        return nueva;
    }
    
    
}
