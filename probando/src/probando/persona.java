/**
 *
 * @author elena
 */
package probando;

public class persona {
    private static int n_personas= 0;
    private String nombre;
    private int anios;
    static String planeta= "Tierra";
    
    public persona(String name, int anios){
        this.nombre= name;
        this.anios= anios;
        n_personas += 1;
    }
    
    static int get_n_personas(){
        return n_personas;
    }
    
    protected String get_nombre(){
        return nombre;
    }
    
    int get_anios(){
        return anios;
    }
 
    protected void set_nombre(String n){
        this.nombre= n;
    }
    
    static String getPlaneta(){
        return planeta;
    }
    
    Object hablar(){
        return "bla bla bla desde persona";
    }
}
