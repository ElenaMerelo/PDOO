/**
 *
 * @author elena
 */

package probando;

public class main_copia {
    public static void main(String[] args) {
        copia c1= new copia();
        
        c1.add(new numero(3));
        c1.add(new numero(2));
        c1.add(new numero(1));
        
        c1.getNumeros().clear(); //podemos borrar los numeros de copia!!
        c1.add(new numero(33));
        c1.show_elements();
        
        c1.getNumeros().get(0).inc(); //y también modificarlos
        c1.show_elements();
        
        copia_defensiva cf1= new copia_defensiva();
        
        cf1.add(new numero(3));
        cf1.add(new numero(2));
        cf1.add(new numero(1));
        
        cf1.getNumeros().clear(); //ya no podemos borrar los numeros de copia!!
        cf1.add(new numero(33));
        cf1.show_elements();
        
        cf1.getNumeros().get(0).inc(); //pero seguimos podiendo modificarlos
        cf1.show_elements();
        
        //No solo tenemos que duplicar la lista sino también sus elementos, sino 
        //ambas comparten las referencias a los mismos objetos
        
        System.out.println("Copia más segura");
        System.out.println("Hay " + copia_mas_segura.getInstancias() + " instancias");
        
        copia_mas_segura c2= new copia_mas_segura();
        System.out.println("Hay " + copia_mas_segura.getInstancias() + " instancias");
        
        copia_mas_segura c3= null;
        System.out.println("Hay " + copia_mas_segura.getInstancias() + " instancias");
        
        try{
            c3= c2.clone(); //al hacer clone no creamos una nueva instancia! Para que se contara tendríamos que llamar al método otraInstancia desde clone()   
        }
        catch (CloneNotSupportedException e){
            System.err.println("CloneNotSupportedException: " + e.getMessage());
        }
        
        System.out.println("Hay " + copia_mas_segura.getInstancias() + " instancias");


      
    }
    
}
