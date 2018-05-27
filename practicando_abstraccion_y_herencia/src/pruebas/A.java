/**
 *
 * @author elena
 */

package pruebas;


public class A {
    private int a= 10;
    private static String s= "hola";
    
    A(int b, String r){
        a= b;
        s= r;
    }
    
    public void met1(int a){
        this.a= a;
    }
    
    protected void met2(String s){
        this.s= s;
    }
    
    public void showA(){
        System.out.println(a);
    }
    
    public void showS(){
        System.out.println(s);
    }
}
