/**
 * @author elena
 * @brief representa a los potenciadores de escudo que pueden tener las estaciones espaciales.
 */
class ShieldBooster {
    private String name;
    private float boost;
    private int uses;
    
    //Constructores
    ShieldBooster(String n, float b, int u){
        name= n;
        boost= b;
        uses= u;
    }
    
    ShieldBooster(ShieldBooster b){
        this(b.name, b.getBoost(), b.getUses());     
    }
    
    //Consultores
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
    
}
