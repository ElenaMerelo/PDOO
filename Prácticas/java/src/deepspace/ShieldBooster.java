/**
 * @author elena
 * @brief representa a los potenciadores de escudo que pueden tener las estaciones espaciales.
 */
package deepspace;

class ShieldBooster {
    private String name;
    private float boost;
    private int uses;
    
    //Constructores
    ShieldBooster(String n, float b, int u){
        this.name= n;
        this.boost= b;
        this.uses= u;
    }
    
    ShieldBooster(ShieldBooster sb){
        this(sb.name, sb.boost, sb.uses);     
    }
    
    //Consultores
    public String getName(){
        return name;
    }
    public float getBoost(){
        return boost;
    }
    
    public int getUses(){
        return uses;
    }
    
    /*
     * @brief Si el valor de uses es mayor que 0, lo decrementa en una unidad 
     * y devuelve el valor del atributo boost; devuelve el valor 1.0 en otro caso.
    */
    public float useIt(){
        if (uses > 0){
            uses--;
            return boost;
        }
        return 1.0f;
    }
    
    public String toString(){
        return name + ": " + boost + " boost, " + uses + " uses.";
    }
    
    ShieldToUI getUIversion(){
        return new ShieldToUI(this);
    }
    
}
