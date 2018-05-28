/**
 *
 * @author elena
 */
package decorator_pattern;


public class Decorator_pattern {
    public static void printInfo(bizcocho b){
        System.out.println("Cost: " + b.getCost() + ", ingredients: " + b.getIngredients());
    }
    
    public static void main(String[] args) {
       bizcocho b= new bizcocho_simple();
       printInfo(b);
       
       b= new ConColacao(b);
       printInfo(b);
       
       b= new ConChocolate(b);
       printInfo(b);
       
       b= new ConColacao(new ConChocolate(new ConChocolate(new ConColacao(b))));
       printInfo(b);
    
    }
    
}
