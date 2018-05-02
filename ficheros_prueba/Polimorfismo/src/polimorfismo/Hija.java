/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfismo;


public class Hija extends Padre{
    private static int c= 33;
    
    Hija(int p){
        super(p);
    }
    
    @Override
    public void deInstancia() {
        System.out.println("Desde la hija. Instancia");
    }
    
    public static void deClase() {
        System.out.println("Desde la hija. Clase" + c);
    }
    
    public void llama_c(){
        c++;
        System.out.println(c + " desde hija");
    }
    
    void met_propio(){
        otro_met();
    }
    
}
