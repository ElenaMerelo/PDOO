/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfismo;


public class Polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Padre p1=new Padre(8);
        p1.deInstancia(); //Desde el padre. instancia
        Hija h1=new Hija(3);
        h1.deInstancia(); //desde la hija. instancia
        Padre p2=new Hija(4); 
        p2.deInstancia(); //desde la hija.instancia
        
        Padre.deClase(); //desde el padre.clase 33
        Hija.deClase();  //desde la hija.clase 33
        
        //Recordad que no se debe hacer lo siguiente
        //Quiero mostrar que a nivel de clase las cosas no funcionan igual
        p1.deClase(); //desde el padre.clase 33
        h1.deClase(); //desde la hija. clase 33
        p2.deClase(); //desde el padre.clase 33
        
        //Muestra que desde un método de instancia se puede llamar a un atributo de clase
        p1.llama_c(); //33 desde padre 
        
        //Si modificamos un atributo de clase en una clase hija también se modifica en la padre
        h1.llama_c(); //34 desde hija
        p1.llama_c(); //34 desde padre 
        p2.llama_c(); //35 desde hija
        
        h1.met_propio(); // desde padre. desde la hija. clase 34
        
    }
    
}
