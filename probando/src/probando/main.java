/**
 *
 * @author elena
 */
package probando;

public class main {
    public static void main(String[] args) {
        
        /* Probando herencia
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
        System.out.println(pp.get_planeta());*/
        
        //Probando polimorfismo
        alumno p1;
        
        // p1= new persona("6543", "e"); da error al interpretar al ser persona > alumno
        p1= new buen_estudiante("43", "r", "gfd", 1, 10.5);
        // p1= new profesor("543", "w", "hgfd", 3); error al interpretar por ser alumno y profesor clases hermanas y no una sublcase de la otra
        zombie p2;
        zombie p3;
        // p2= new profesor("432", "5434", "d", 1); error al interpretar, profesor no implenta la interfaz zombie
        p2= new alumno("5432", "5432", "e", 1);
        p3= new buen_estudiante("34", "buen estudiante", "54", 1, 4.5);
        
        p2.hambre();
        p2.suenio();
        p3.hambre();
        p3.suenio();
        
        persona p4= new alumno("5432", "5432", "e", 1);
        persona p5= new buen_estudiante("543", "543", "t3", 1, 0.0);
        System.out.println(((persona)p4).hablar());
        System.out.println(((alumno)p5).hablar());
        
        //Otros ejemplos 
        persona p6= new persona("5432", "persona");
        alumno a= new alumno("6543", "alumno", "5432",1);
        
        p6= a;
        System.out.println(p6.hablar());
        
        a= (alumno) p3;
        System.out.println(a.get_nombre());
        
     
        
    }
    
    
}
