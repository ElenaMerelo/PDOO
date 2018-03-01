/**
 * @author elena
 * @brief Esta clase representa a las armas de las que puede disponer una estación 
 * espacial para potenciar su energía al disparar.
 */
class Weapon {
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
        this(w.name, w.getType(), w.getUses());
    }
    
    //Consultores 
    public WeaponType getType(){
        return type;
    }
    
    public int getUses(){
        return uses;
    }
    
    /*
     * @brief Devuelve la potencia de disparo indicada por el tipo de arma.
    */
    public float power(){
        return type.getPower();
    }
    
    /*
    * @brief Si el valor del atributo uses es mayor que 0, lo decrementa en una 
    * unidad y devuelve el valor del método power(); devuelve el valor 1.0 en 
    * otro caso.
    */
    public float useIt(){
        if( uses > 0){
            uses--;
            return power();
        }
        return 1.0f;
    }
}
