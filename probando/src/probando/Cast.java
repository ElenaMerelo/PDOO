package probando;

interface interface1 {void met1();}
interface interface2 {void met2();}
interface interface3 {void met3();}
abstract class A1 implements interface1,interface2 {}
class B extends A1 implements interface3 {
    @Override
    public void met1(){
      System.out.println("met1 desde B");
    }
    
    @Override
    public void met2(){
      System.out.println("met2 desde B");
    }
    
    @Override
    public void met3(){
      System.out.println("met3 desde B");
    }
}

class C extends A1 {
    @Override
    public void met1(){
      System.out.println("met1 desde C");
    }
    @Override
    public void met2(){
      System.out.println("met2 desde C");

    }
}
class D extends B{
    public void met4(){
        System.out.println("met4 desde D");
    }
}

class Padre{
    public void  metodo1() {
        System.out.println("Met1");
        metodo2();
    }

    public void metodo2() {
        System.out.println("Met2");

    }
}

class Hijo extends Padre {

    public void metodo2() {
        System.out.println("Met2-Hijo");
    }

}

class Nieto extends Hijo {

    public void  metodo1() {
        System.out.println("Met1-Nieto");
        metodo2();
    }
    
    public void metodo4(){
        System.out.println("Met4");
    }

}

public class Cast {
    public static void main(String[] args) {
        interface1 i1;
        //i1=new interface1(); no se puede instanciar una interfaz
        i1=new D(); // bien ya que D hereda de B que hereda de A que implementa interface1
      	i1.met1(); //met1 desde B, no lo tiene implementado D por lo que se va a su padre
        //i1.met4(); no funciona para un met distinto de 1, que es el que está en la interfaz
        i1=new C(); //bien, C extends A que implementa i1
        i1.met1(); //met1 desde C
      	i1=new B(); //bien, B implementa interface1
        i1.met1(); //met1 desde B
        
        System.out.println("======");

        A1 a=new B(); //se puede hacer, B es hija de A
        a.met2();
        i1=a; // ahora el tipo dinámico de i1 será B
        i1.met1();
        //i1.met2(); en interface1 no está met2
        //a=i1; // interface1 no puede convertirse a A1, aunque tengan el mismo tipo dinámico
        //i1=new A1(); //mal, A1 es abstracta
        //D d= new B(); //mal, el tipo estático es menor que el dinámico
        B b= new B(); //bien
        b.met2();
        //D d=b; // mal, lo mismo que en línea 66
        //D d=(D) b; //error ejecución, todo b no es un d
        D d=new D(); //Bien
        d.met4();
        d.met1(); //Llama a met1 desde D, que no lo tiene implementado, luego toma el del padre
        System.out.println("======");

        ((interface1) d).met1(); //bien, si ponemos met2 mal porque no está en i1
        
        interface2 i2=d; //bien porque D extends B que hereda de una clase que la implementa
        //i2.met1(); //mal, met1 no está en i2
        i2.met2();
        //((interface2) d).met1(); //met1 no está en i2
        ((interface2) d).met2();

        //B ultima=(A1) new C(); //A1 cannot be converted to B
        //B ultima=(B) new C(); // una C no puede ser una B, C cannot be converted to B
        //B ultima=(B) (A1) new C(); //error al ejecutar: probando.C cannot be cast to probando.B
        Padre p= new Nieto();
        p.metodo1();
        ((Padre) p).metodo2();
    }

}
