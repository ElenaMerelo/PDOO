/**
 *
 * @author elena
 */

package probando;

class numero {
    private Integer i;
    
    public numero(Integer a){
        i= a;
    }
    
    public void inc(){
        i++;
    }
    
    @Override 
    public String toString(){
        return i.toString();
    }
}
