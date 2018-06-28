/**
 *
 * @author elena
 */

package controller;

import java.util.ArrayList;

import GUI.MainView;
import deepspace.GameUniverse;
import deepspace.GameUniverseToUI;
import deepspace.CombatResult;
import deepspace.GameState;
import deepspace.HangarToUI;

public class Controller {
    private GameUniverse model;
    private MainView view;
    
    public Controller(GameUniverse g, MainView m){
        model= g;
        view= m;
        view.setController(this);
    }
    
    public void start(){
        model.init(view.getNames());
        view.updateView();
        view.showView();
       
    }
    
    public void finish(int i){
        if(view.confirmExitMessage())
            System.exit(i);
    }
    
    public GameState getState(){
        return model.getState();
    }
    
    
    
    
}
