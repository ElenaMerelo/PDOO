/**
 *
 * @author elena
 */
package decorator_pattern;


public class bizcocho_simple implements bizcocho {
    @Override
    public double getCost(){
        return 5.43;
    }
    
    @Override
    public String getIngredients(){
        return "harina, huevos, levadura, aceite, amor";
    }
}
