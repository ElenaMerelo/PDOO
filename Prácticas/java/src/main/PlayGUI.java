/**
 *
 * @author elena
 */

package main;

import deepspace.GameUniverse;
import GUI.MainView;
import controller.Controller;

class PlayGUI {
    public static void main(String[] args) {
        GameUniverse game = new GameUniverse();
        MainView view = new MainView();
        Controller controller = new Controller (game,view);
        
        controller.start();   // Let's play whith 2 players
    }
    
}