/**
 *
 * @author Profesor
 */

package deepspace;

class GameStateController {
    private GameState state;
    
    GameStateController() {
        state=GameState.CANNOTPLAY;        
    }

    public GameState getState() {
        return state;
    }
    
    public GameState next(int turn,int nPlayers) {
        switch (state) {
            case CANNOTPLAY: 
                state=GameState.INIT;
                break;
            case INIT: 
                state=GameState.AFTERCOMBAT;
                break;                
            case BEFORECOMBAT: 
                state=GameState.AFTERCOMBAT;
                break;
            case AFTERCOMBAT: 
                if (turn>=nPlayers)
                    state=GameState.BEFORECOMBAT;
                else
                    state=GameState.INIT;
                break;                
        }
        return state;
    }
}
