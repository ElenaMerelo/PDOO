/**
 *
 * @author elena
 */

package probando;

class numero_v2 implements Cloneable {
    private Integer i;
    
    public numero_v2(Integer a){
        i= a;
    }
    
    public void inc(){
        i++;
    }
    
    @Override 
    public String toString(){
        return i.toString();
    }
    
    @Override
    public numero_v2 clone() throws CloneNotSupportedException {
        //Los objetos de la clase Integer son inmutables
        return (numero_v2) super.clone();
    }
}
