/**
 *
 * @author elena
 */

package main_p5;
import View.*;
import model.*;
import View.GUI.*;
import Controller.*;

public class play {
    public static void main(String [] args){
        Model model = new Model();
        View view = new MainWindow();
        Controller controller = new Controller(model,view);
        controller.start();
    }
}
