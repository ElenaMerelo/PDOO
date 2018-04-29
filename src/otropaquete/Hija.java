/**
 *
 * @author elena
 */

package otropaquete;

//Ha de ponerse tanto la clase, como el constructor y el método públicos para poder acceder a ellos desde el main, que está en otro paquete
public class Hija extends Test {
    public Hija(){
        super("privadohija", "protegidohija", "paquetehija", "publicohija");
    }
    
    public void metodo() {
        // System.out.println(privado) Error al estar accediendo desde una clase distinta a desde la que se declara 
        System.out.println(protegido); //Bien, un atributo protected se puede acceder desde subclases
        System.out.println(paquete); //Accesible al estar dentro del mismo paquete que test        
        System.out.println(publico);  //Siempre se puede acceder a un atributo público        
    }
}