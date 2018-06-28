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
    
    public void mountItems(ArrayList<Integer> w, ArrayList<Integer> s){
        int i;
        for(i= w.size() -1; i >= 0; i--)
            model.mountWeapon(w.get(i));
        
        for(i= s.size() -1; i >= 0; i--)
            model.mountShieldBooster(s.get(i)); 
    }
    
    public void discardItemsInHangar(ArrayList<Integer> w, ArrayList<Integer> s){
        int i;
        for(i= w.size() -1; i >= 0; i--)
            model.discardWeaponInHangar(w.get(i));
        
        for(i= s.size() -1; i >= 0; i--)
            model.discardShieldBoosterInHangar(s.get(i)); 
    }
    
    public void discardWeapons(ArrayList<Integer> w){
        for(int i= w.size() -1; i >= 0; i--)
            model.discardWeapon(w.get(i));
    }
    
    public void discardShields(ArrayList<Integer> s){
        for(int i= s.size() -1; i >= 0; i--)
            model.discardShieldBooster(s.get(i));
    }
    
    public void discardHangar(){
       model.discardHangar();
       view.updateView();
    }
    
    
    
    
}
