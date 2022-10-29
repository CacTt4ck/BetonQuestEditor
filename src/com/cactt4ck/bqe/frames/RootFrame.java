package com.cactt4ck.bqe.frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RootFrame extends JFrame {

    public RootFrame(String title) {
        super(title);
        this.setSize(1280, 720);
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/image/Icon 64.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new RootPanel(new BorderLayout(), this));
        this.setVisible(true);
    }

}
