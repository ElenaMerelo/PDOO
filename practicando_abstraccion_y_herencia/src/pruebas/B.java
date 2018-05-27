/**
 *
 * @author elena
 */

package pruebas;

public abstract class B extends A {
    B(){
        super(100, "hola abstracto");
    }
    
    public void met1(int a){
        System.out.println("Met1 abstracto");
        super.met1(a+10);
    }
    
    public abstract void met2(String s);
}
