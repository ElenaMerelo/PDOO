/**
 *
 * @author elena
 */
package otropaquete;

//Ha de ponerse todo público
public class NoPariente {
    public void metodo(){
        Test test=new Test("privadonp", "protegidonp", "paquetenp", "publiconp");
        //System.out.println(test.privado); Error al estar intentando acceder a un atributo privado de otra clase        
        System.out.println(test.protegido); //Error al no ser subclase de test
        System.out.println(test.paquete);  //Bien porque están en el mismo paquete  
        System.out.println(test.publico);  //Siempre bien    
    }
}