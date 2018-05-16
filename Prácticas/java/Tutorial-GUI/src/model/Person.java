/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Profe
 */
class Person {
    private String name;
    private ArrayList<BankCheck> bankChecks = new ArrayList();

    Person(String n) {
        name = n;
    }

    String getName() {
        return name;
    }
    
    int getTotal () {
        int total = 0;
        for (BankCheck bc : bankChecks) {
            total += bc.getAmount();
        }
        return total;
    }

    ArrayList<BankCheck> getBankChecks() {
        return bankChecks;
    }
    
    void getAnotherBankCheck() {
        bankChecks.add (new BankCheck ());
    }

    void spendBankCheck(int i) {
        if (i > -1 && i < bankChecks.size())
            bankChecks.remove(i);
    }
    
    public PersonToUI getUIversion() {
        return new PersonToUI (this);
    }

}
