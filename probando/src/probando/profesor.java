/**
 *
 * @author elena
 */

package probando;

public class profesor extends persona{
    String asignatura;
    int experiencia;
    static String planeta= "Marte";
    
    public static String get_planeta(){
        return planeta;
    }
    
    public profesor(String d, String n, String a, int e){
        super(d, n);
        this.asignatura= a;
        this.experiencia= e;
    }
    
    
    
    public String get_nombre_y_dni(){
        return "Nombre " + this.get_nombre() + " dni " + this.get_dni();
    }
    
    @Override
    public String hablar(){
        return "Estimados" + super.hablar();
    }
}
