/**
 *
 * @author elena
 */

package View;

import Controller.Controller;
import java.util.ArrayList;

public interface View {
    public void setController(Controller c);
    //public void updateView();
    public void showView();
    public String getAppName();
    // Dialogs
    public ArrayList<String> getNames();
    // Messages
    public boolean confirmExitMessage(); 
}
