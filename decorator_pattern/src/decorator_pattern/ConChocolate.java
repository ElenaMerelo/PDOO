/**
 *
 * @author elena
 */
package decorator_pattern;


public class ConChocolate extends bizcocho_decorator {
    public ConChocolate(bizcocho b){
        super(b);
    }
    
    public double getCost(){
        return super.getCost() + 1.618;
    }
    
    public String getIngredients(){
        return super.getIngredients() + ", shocolatito";
    }
}
