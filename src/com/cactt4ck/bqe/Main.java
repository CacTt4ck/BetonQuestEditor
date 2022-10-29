package com.cactt4ck.bqe;

import com.cactt4ck.bqe.frames.RootFrame;

import javax.swing.*;

public class Main {

    public static final String TITLE = "Beton Quest Editor";

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.invokeLater(() -> new RootFrame(TITLE));
    }

}
