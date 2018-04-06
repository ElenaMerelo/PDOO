/**
 * @author elena
 * @brief Esta clase representa a las armas de las que puede disponer una estación 
 * espacial para potenciar su energía al disparar.
 */
package deepspace;

class Weapon{
    private String name;
    private WeaponType type;
    private int uses;
    
    //Constructores
    Weapon(String n, WeaponType t, int u){
        this.name= n;
        this.type= t;
        this.uses= u;
    }
    
    Weapon(Weapon w){
        this(w.name, w.type, w.uses);
    }
    
    //Consultores
    public String getName(){
        return name;
    }
    
    public WeaponType getType(){
        return type;
    }
    
    public int getUses(){
        return uses;
    }
    
    /**
     * @brief Devuelve la potencia de disparo indicada por el tipo de arma.
    */
    public float power(){
        return type.getPower();
    }
    
    /**
    * @brief Si el valor del atributo uses es mayor que 0, lo decrementa en una 
    * unidad y devuelve el valor del método power(); devuelve el valor 1.0 en 
    * otro caso.
    */
    public float useIt(){
        if( uses > 0){
            uses--;
            return this.power();
        }
        return 1.0f;
    }
    
    public String toString(){
        return name + " " + type + " " + uses;
    }
    
    WeaponToUI getUIversion(){
        return new WeaponToUI(this);
    }
}
