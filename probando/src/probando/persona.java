/**
 *
 * @author elena
 */
package probando;

public class persona {
    private static int n_personas= 0;
    protected String dni;
    private String nombre;
    static String planeta= "Tierra";
    
    public persona(String d, String n){
        this.dni= d;
        this.nombre= n;
        n_personas += 1;
    }
    
    static int get_n_personas(){
        return n_personas;
    }
    
    public static String get_planeta(){
        return planeta;
    }
    
    protected String get_nombre(){
        return nombre;
    }
    
    protected String get_dni(){
        return dni;
    }
    
    protected void set_nombre(String n){
        this.nombre= n;
    }
    
    void set_dni(String d){
        this.dni= d;
    }
    
    Object hablar(){
        return "bla bla bla";
    }
}
