/**
 * @author Profesor y Elena Merelo
 * @param <T>
 */
package deepspace;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

class CardDeck<T extends Copyable<T>> {    
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
        
        return card.copy();
    }
    
    private void shuffle() {
        Collections.shuffle(cards);
    }
    
    boolean justShuffled() {
        return (count==0);
    }
    
    public String to_string(){
        return cards + " cards" + ready + " ready" + count + " count";
    }
}

