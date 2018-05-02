/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfismo;


public class Padre {
    static int c= 33;
    private int a= 44;
    
    Padre(int b){
        a= b;
        System.out.println("Constructor de padre");
    }
    
    public void deInstancia() {
        System.out.println("Desde el padre. Instancia");
    }
    
    public static void deClase() {
        System.out.println("Desde el padre. Clase" + c);
    } 
    
    public void llama_c(){
        System.out.println(c + " desde padre");
    }
    
    void otro_met(){
        System.out.println("Desde padre");
        deClase();
    }
}
