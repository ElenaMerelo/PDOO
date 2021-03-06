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
    
    public boolean haveAWinner(){
        return model.haveAWinner();
    }
    
    /*
    public boolean noMoreReanimaciones(){
        return model.noMoreReanimaciones();
    }
   */ 
    public GameState getState(){
        return model.getState();
    }
    
    /*
    public boolean spaceStationNeedsHelp(){
        return model.spaceStationNeedsHelp();
    }
    
    public void fixUses(){
        model.fixUses();
        view.updateView();
    }
    
    public void littleHelp(){
        model.addCombatElement();
        view.updateView();
    }
    */
    public void mountItems(ArrayList<Integer> w, ArrayList<Integer> s){
        int i, diff= model.getUIversion().getCurrentStation().getHangar().getWeapons().size();
        for(i= w.size() -1; i >= 0; i--)
            model.mountWeapon(w.get(i));
        
        //diff= model.getUIversion().getCurrentStation().getHangar().getWeapons().size();
        
        for(i= s.size() -1; i >= 0; i--)
            model.mountShieldBooster(s.get(i) - diff); 
        
        view.updateView();
    }
    
    public void discardItemsInHangar(ArrayList<Integer> w, ArrayList<Integer> s){
        int i, diff;
        for(i= w.size() -1; i >= 0; i--)
            model.discardWeaponInHangar(w.get(i));
        
        diff= w.size();
        
        for(i= s.size() -1; i >= 0; i--)
            model.discardShieldBoosterInHangar(s.get(i) - diff); 
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
    
    public CombatResult combat(){
        CombatResult cr= model.combat();
        view.showResultMessage(cr);
        view.updateView();
        return cr;
    }
    
    public void updateView(){
        view.updateView();
    }
    
    public GameUniverseToUI getUIversion(){
        return model.getUIversion();
    }
    
    public boolean nextTurn(){
        boolean result = model.nextTurn();
        if(!result)
            view.showNextTurnMessage();
        
        view.updateView();
        return result;
    }
    
    /*
    public void reanimar(){
        model.reanimar();
        view.updateView();
    }
    
    public boolean spaceStationIsDead(){
        return model.spaceStationIsDead();
    }*/
}
