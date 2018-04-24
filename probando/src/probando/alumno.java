/**
 *
 * @author elena
 */
package probando;

public class alumno extends persona {
    String carrera;
    int curso;
    
    public alumno(String d, String n, String c, int a){
        super(d, n);
        this.carrera= c;
        this.curso= a;
    }
    
}
