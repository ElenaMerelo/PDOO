/**
 *
 * @author elena
 */
package probando;

public class main {
    public static void main(String[] args) {
        persona p= new persona("1234Y", "elena");
        System.out.println("N personas " + p.get_n_personas() + " nombre " + p.get_nombre());
        
        profesor pp= new profesor("544532g", "pp", "pdoo", 3);
        System.out.println(pp.dni);
        profesor.get_n_personas();
        persona.get_n_personas();
        
        System.out.println(profesor.get_n_personas());
        System.out.println(persona.get_n_personas());
        
        System.out.println(pp.asignatura);
        System.out.println(pp.get_dni());
        pp.set_nombre("luis");
        pp.dni= "65432f";
        
        System.out.println("N personas " + pp.get_n_personas() + " nombre " + pp.get_nombre());
        System.out.println(pp.get_nombre_y_dni());
        
        profesor otro=new profesor("2222", "pro", "mi", 5);
        System.out.println(otro.hablar());
        
        persona nueva= new persona("1111", "t");
        System.out.println(nueva.hablar());
        
        System.out.println(p.get_planeta());
        System.out.println(pp.get_planeta());
    }
    
}
