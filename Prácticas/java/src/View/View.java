/**
 *
 * @author elena
 */

package View;

import Controller.Controller;
import java.util.ArrayList;

public interface View {
    public void setController(Controller c);
    public void updateView();
    public void showView();
    public String getAppName();
    // Dialogs
    public ArrayList<String> getNames();
    // Messages
    public boolean confirmExitMessage(); 
    public void showNextTurnError();
    public void showEnemyWinsMessage();
    public void showStationEscapesMessage();
    public void showYouWinMessage();
    public void showYouWinAndConvertMessage();
    public void showVictoryMessage();
}
