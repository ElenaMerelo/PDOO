/**
 * @author Elena Merelo
 */
package deepspace;

class EnemyStarShip {
    private float ammoPower, shieldPower;
    private String name;
    private Loot loot;
    private Damage damage;
    
    //Constructores 
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name= n;
        ammoPower= a;
        shieldPower= s;
        damage= d;
        loot= l;
    }
    
    EnemyStarShip(EnemyStarShip e){
        this(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage);
    }
    
    //Getters
    EnemyToUI getUIversion(){
        return new EnemyToUI(this);
    } 

    public float getAmmoPower(){
        return ammoPower;
    }
    
    public String getName(){
        return name;
    }

    public float getShieldPower(){
        return shieldPower;
    }

    public Damage getDamage(){
        return damage;
    }

    public Loot getLoot(){
        return loot;
    }
    
    //Otros métodos 
    public float fire(){
        return getAmmoPower();
    }
    
    public float protection(){
        return getShieldPower();
    }
    
    /*
     * @brief Devuelve el resultado que se produce al recibir un disparo de
     * una determinada potencia (pasada como parámetro). Si el nivel de protección 
     * de los escudos es menor que la intensidad del disparo, la nave enemiga 
     * no resiste (DONOTRESIST). En caso contrario resiste el disparo (RESIST). 
     * Se devuelve el resultado producido por el disparo recibido.
    */
    public ShotResult receiveShot(float shot){
        if(shieldPower < shot)
            return ShotResult.DONOTRESIST;
        return ShotResult.RESIST;
    }
    
    
    
    
    
    
    
    
    
}











