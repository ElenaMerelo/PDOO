/**
 *
 * @author elena
 */
package probando;

public class alumno extends persona implements zombie{
    public alumno(String name, int anios){
        super(name, anios);
    }
    
    @Override
    public void suenio(){
        System.out.println("Tengo sueño desde alumno");
    }
    
    @Override
    public void hambre(){
        System.out.println("Tengo hambre desde alumno");
    }
    
    public String hablar(){
        return "Hablar desde alumno";
    }
    
}
