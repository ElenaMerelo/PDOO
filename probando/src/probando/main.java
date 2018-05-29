/**
 *
 * @author elena
 */
package probando;

public class main {
    public static void main(String[] args) {
        
        /*
        //Probando herencia
        persona p= new persona("elena", 19);
        System.out.println("N personas " + p.get_n_personas() + " nombre " + p.get_nombre() + p.getPlaneta());
        
        profesor pp= new profesor("pp", 33);
        
        System.out.println(profesor.get_n_personas());
        System.out.println(persona.get_n_personas());
        
        pp.set_nombre("luis");
        
        System.out.println("N personas " + pp.get_n_personas() + " nombre " + pp.get_nombre() + pp.getPlaneta());
        
        profesor otro= new profesor("pro", 55);
        System.out.println(otro.hablar());
        
        persona nueva= new persona("1111", 123);
        System.out.println(nueva.hablar());
        
        persona z= new alumno("erwf", 23);
        System.out.println(z.get_nombre());
        */
        
        //Probando polimorfismo
        alumno p1;
        
        // p1= new persona("6543", "e"); da error al interpretar al ser persona > alumno
        p1= new buen_estudiante("gfd", 10, 10.5);
        // p1= new profesor("hgfd", 3); error al interpretar por ser alumno y profesor clases hermanas y no una subclase de la otra
        zombie p2;
        zombie p3;
        // p2= new profesor("d", 1); error al interpretar, profesor no implementa la interfaz zombie
        p2= new alumno("e", 1);
        p3= new buen_estudiante("buen estudiante", 1, 4.5);
        
        p2.hambre();
        p2.suenio();
        p3.hambre();
        p3.suenio();
        
        persona p4= new alumno("e", 1);
        persona p5= new buen_estudiante("t3", 1, 0.0);
        System.out.println(((persona)p4).hablar());
        System.out.println(((alumno)p5).hablar());
        
        //Otros ejemplos 
        persona p6= new persona("persona", 543);
        alumno a= new alumno("5432",1);
        
        p6= a;
        System.out.println(p6.hablar());
        
        a= (alumno) p3;
        System.out.println(a.get_nombre());
        
        zombie p7= new alumno("zombie", 54343);
        persona b= (persona) p7;
        System.out.println(b.hablar());
        // b.hambre(); no está en persona

        
    }
    
    
}
