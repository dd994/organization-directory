package com.gmail.ddzhunenko.organizationdirectory.admin.actions;


import javafx.event.ActionEvent;

import javax.swing.*;


public  class TestAction extends AbstractAction {

    public TestAction(String text, ImageIcon icon,
                      String desc, Integer mnemonic) {
        super(text, icon);
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("sdfds");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("sdfds");
    }

    @Override
    public boolean accept(Object sender) {
        return false;
    }
}