package visibilidad;

import otropaquete.*;

//Aquí ya no hace falta poner public 
class Hija2 extends Test {
    Hija2(){
        super("privadohija2", "protegidohija2", "paquetehija2", "publicohija2");
    }
    
    void metodo() {
        //System.out.println(privado);  Error al estar accediendo desde otra clase
        System.out.println(protegido); //Bien al ser subclase, aunque sea otro paquete
        // System.out.println(paquete);  Error al estar en otro paquete      
        System.out.println(publico);        
    }
}



public class Visibilidad {
    public static void main(String[] args) {       
        Test test=new Test("privado1", "protegido1", "paquete1", "publico1");
        Test test2=new Test("privado2", "protegido2", "paquete2", "publico2");        
        
        // System.out.println(test.privado); No se puede acceder a privado desde fuera de la propia clase       
        // System.out.println(test.protegido); Mal al no estar Visibilidad en el mismo paquete que test
        // System.out.println(test.paquete); Mal al estar en otro paquete    
        System.out.println(test.publico);     
        
        test.otroMetodo();
        test.otroMetodo(test2);
        
        Hija h= new Hija();
        h.metodo();
        
        NoPariente p= new NoPariente();
        p.metodo();
        
        Hija2 h2= new Hija2();
        h2.metodo();
 
    }
}

/* 
publico1 
privado1 
protegido1 
paquete1
publico1 
privado2
protegido2 
paquete2 
publico2
protegidohija 
pauquetehija 
publicohija 
protegidonp
paquetenp 
publiconp 
protegidohija2 
publicohija2
*/










