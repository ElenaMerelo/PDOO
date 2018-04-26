/**
 *
 * @author elena
 */
package probando;

public class alumno extends persona implements zombie{
    String carrera;
    int curso;
    
    public alumno(String d, String n, String c, int a){
        super(d, n);
        this.carrera= c;
        this.curso= a;
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
