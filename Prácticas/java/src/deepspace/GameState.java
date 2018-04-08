/**
 *
 * @author Profesor
 */

package deepspace;

public enum GameState {
    CANNOTPLAY, INIT,BEFORECOMBAT,AFTERCOMBAT
    /*  
    CANNOTPLAY:     the Gameuniverse has been created but not initialized
    INIT:   the GameUniverse has been initialized and the current player has not combated. 
            Players can mount weapons and shielboosters, or combat
    BEFORECOMBAT:   players can only combat
    AFTERCOMBAT:    players can mount/discard weapons,shielboosters and hangars 
    */
}

//    INIT:   the GameUniverse has been initialized and the current player has not combated. 
//            Players can mount/discard weapons,shielboosters and hangars or combat
