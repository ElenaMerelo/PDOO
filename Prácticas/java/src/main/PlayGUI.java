/**
 *
 * @author elena
 */

package main;

import deepspace.GameUniverse;
import GUI.View;
import View.GUI.MainView;
import Controller.Controller;

class PlayGUI {
    public static void main(String[] args) {
        GameUniverse game = new GameUniverse();
        View view = new MainWindow();
        Controller controller = new Controller (game,view);
        
        controller.start();   // Let's play whith 2 players
    }
    
}