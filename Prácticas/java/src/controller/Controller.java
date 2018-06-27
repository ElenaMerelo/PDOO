/**
 *
 * @author elena
 */

package controller;

import GUI.*;
import deepspace.*;
import java.util.ArrayList;


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
        System.exit(i);
    }
    
    
}
