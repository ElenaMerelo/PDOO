/**
 *
 * @author elena
 */
package decorator_pattern;


public class ConColacao extends bizcocho_decorator {
    public ConColacao(bizcocho b){
        super(b);
    }
    
    public double getCost(){
        return super.getCost() + 3.141592;
    }
    
    public String getIngredients(){
        return super.getIngredients() + ", colacao";
    }
}
