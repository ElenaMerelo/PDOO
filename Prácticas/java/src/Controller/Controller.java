/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import java.util.ArrayList;
import model.AppState;
import model.Model;
import model.ModelToUI;

/**
 *
 * @author Profe
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.setController(this);
    }

    public void start() {
        model.init(view.getNames());
        view.updateView();
        view.showView();
    }
    
    public void finish(int i) {
        if (view.confirmExitMessage())
            System.exit(i);
    }
    
    public AppState getAppState () {
        return model.getAppState();
    }
    
    public ModelToUI getModelToUI () {
        return model.getUIversion();
    }

    public void getNewBankChecks(int howMany) {
        for (int i = 0; i < howMany; i++)
            model.getAnotherBankCheck();
        view.updateView();
    }

    public void next() {
        model.next();
        view.updateView();
    }

    public void spendBankChecks(ArrayList<Integer> selectedChecks) {
        for (int i = selectedChecks.size() - 1; i >= 0; i--) {
            model.spendBankCheck(selectedChecks.get(i));
        }
        view.updateView();
    }
    
    public void spendBankChecks(int selectedCheck) {
        model.spendBankCheck(selectedCheck);
        view.updateView();
    }
    
}
