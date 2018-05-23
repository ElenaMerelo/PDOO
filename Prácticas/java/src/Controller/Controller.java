/**
 *
 * @author elena
 */
package Controller;

import View.View;
import View.MainWindow;
import View.NamesCapture;
import java.util.ArrayList;

import deepspace.CombatResult;
import deepspace.GameState;
import deepspace.GameUniverse;
import deepspace.GameUniverseToUI;
import deepspace.LootToUI;
import deepspace.WeaponToUI;
import deepspace.SpaceStationToUI;
import deepspace.WeaponType;



public class Controller {
    private GameUniverse model;
    private View view;

    public Controller(GameUniverse m, View v) {
        model = m;
        view = v;
        view.setController(this);
    }

    public void start() {
        model.init( ( (MainWindow) view).getNames() );
        view.updateView();
        view.showView();
    }
    
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(this.model);
    }
    
    public void finish(int i) {
        if (view.confirmExitMessage())
            System.exit(i);
    }
    
    public GameState getState(){
        return model.getState();
    }
    
    public void mountCombatElements(ArrayList<Integer> hangar_items){
        
    }

    
}
