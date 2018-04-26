/**
 *
 * @author elena
 */

package probando;

public class buen_estudiante extends alumno {
    private double nota;
    
    buen_estudiante(String d, String n, String c, int a, double nota){
        super(d, n, c, a);
        this.nota= nota;
    }
    
    public void suenio(){
        System.out.println("Tengo suenio desde buen estudiante");
    }
    
    public void hambre(){
        System.out.println("Tengo hambre desde buen estudiante");
    }
    
    public String hablar(){
        return "Hablando desde buen estudiante";
    }
}
