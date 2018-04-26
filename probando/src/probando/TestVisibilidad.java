/**
 *
 * @author elena
 */

package probando;

public class TestVisibilidad {
    public static void main(String[] args) {
        clase o=new clase();
        clase o2= new clase();
        
        System.out.println(o.get_attr());
        o2.set_attr(3);
        System.out.println(o2.get_attr());
        o2.copiaAtributo(o);
        
        System.out.println(o.get_attr());
        System.out.println(o2.get_attr());
    }
}
