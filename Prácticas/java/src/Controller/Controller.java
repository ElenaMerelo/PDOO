/**
 *
 * @author elena
 */
package Controller;

import View.View;
import View.MainWindow;
import View.NamesCapture;
import java.util.ArrayList;

import deepspace.*;



public class Controller {
    private GameUniverse model;
    private View view;

    public Controller(GameUniverse m, View v) {
        model = m;
        view = v;
        view.setController(this);
    }

    public void start() {
        model.init(view.getNames());
        view.updateView();
        view.showView();
    }
    
    public GameUniverseToUI getUIversion(){
        return model.getUIversion();
    }
    
    public void finish(int i) {
        if (view.confirmExitMessage())
            System.exit(i);
    }
    
    public GameState getState(){
        return model.getState();
    }
    
    public SpaceStationToUI currentStation(){
        return model.getUIversion().getCurrentStation();
    }
    
    public EnemyToUI currentEnemy(){
        return model.getUIversion().getCurrentEnemy();
    }
    
    public CombatResult combat() {
        CombatResult result = model.combat();
        switch( result ){
            case ENEMYWINS:
                view.showEnemyWinsMessage();
                break;
            case STATIONESCAPES:
                view.showStationEscapesMessage();
                break;
            case STATIONWINS:
                if( haveAWinner() ){
                    view.showVictoryMessage();
                    System.exit(0);
                } else view.showYouWinMessage();
                break;
            case STATIONWINSANDCONVERTS:
                if( haveAWinner() ){
                    view.showVictoryMessage();
                    System.exit(0);
                } else view.showYouWinAndConvertMessage();
                break;
                
        }
        view.updateView();
        return result;
}   
    
    public boolean haveAWinner(){
        return model.haveAWinner();
    }
    
    public void discardHangar(){
        model.discardHangar();
        view.updateView();
    }
    
    public boolean nextTurn(){
        boolean t= model.nextTurn();
        view.updateView();
        return t;
    }
    
    public void mountWeapon(int i){
        model.mountWeapon(i); 
        view.updateView();
    }
    
    public void mountShieldBooster(int i){
        model.mountShieldBooster(i);
        view.updateView();
    }
    
    public void discardWeapon(int i){
        model.discardWeapon(i);
        view.updateView();
    }
    
    public void discardWeaponInHangar(int i){
        model.discardWeaponInHangar(i);
        view.updateView();
    }

    public void discardShieldBooster(int i){
        model.discardShieldBooster(i);
        view.updateView();
    }
    
    public void discardShieldBoosterInHangar(int i){
        model.discardShieldBoosterInHangar(i);
        view.updateView();
    }   
    
    
   
    
    
    
    
    
    
    
    
    
    
}
