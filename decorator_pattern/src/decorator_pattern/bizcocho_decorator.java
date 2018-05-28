/**
 *
 * @author elena
 */
package decorator_pattern;


public abstract class bizcocho_decorator implements bizcocho {
    protected final bizcocho decorated_bizcocho;
    
    public bizcocho_decorator(bizcocho b){
        this.decorated_bizcocho= b; 
    }
    
    @Override
    public double getCost(){
        return decorated_bizcocho.getCost();
    }
    
    @Override
    public String getIngredients(){
        return decorated_bizcocho.getIngredients();
    }
    
}
