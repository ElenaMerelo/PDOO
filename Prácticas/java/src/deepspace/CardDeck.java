/**
 *
 * @author Profesor
 * @param <T>
 */

package deepspace;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class CardDeck<T> {    
    private ArrayList<T> cards=new ArrayList();
    private boolean ready;
    private int count;
    
    CardDeck() {
        ready=false;
        count=0;
    }
    
    public void add(T t) {
        if (!ready)
            cards.add(t);
    }
    
    public T next() {
        if (!ready) {
            ready=true;
            shuffle();
        }

        T card=cards.remove(0);
        cards.add(card);
        
        count++;
        if (count==cards.size()) {
            shuffle();
            count=0;
        }
        
        T t=null;
        try {
            Class<T> clazz = (Class<T>) card.getClass();
            Constructor<T> c= clazz.getDeclaredConstructor(clazz);
            t = c.newInstance( card );
        } catch (ReflectiveOperationException ex) {
            Logger.getLogger(CardDeck.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
        
        //return card;
    }
    
    private void shuffle() {
        Collections.shuffle(cards);
    }
    
    boolean justShuffled() {
        return (count==0);
    }
}
