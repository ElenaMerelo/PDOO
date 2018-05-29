/**
 *
 * @author elena
 */

package probando;

public class profesor extends persona{
    static String planeta= "Marte";
    
    public static String getPlaneta(){
        return planeta;
    }
    
    public profesor(String n, int a){
        super(n, a);
    }
    
    
    
    public String get_nombre_y_anios(){
        return "Nombre " + this.get_nombre() + " dni " + this.get_anios();
    }
    
    @Override
    public String hablar(){
        return "Hablar desde profesor";
    }
}
