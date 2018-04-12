/**
 *
 * @author Profe
 */

package main;

import UI.TextUI;
import controller.ControllerText;
import deepspace.GameUniverse;

public class PlayWithUI {
    public static void main(String[] args) {
        GameUniverse game = new GameUniverse();
        TextUI tui = TextUI.getInstance();
        ControllerText controller = new ControllerText (game,tui);
        // You can play with multiple players
        // You can read from console how many players you want
        
        controller.start(2);   // Let's play whith 2 players
    }
}
