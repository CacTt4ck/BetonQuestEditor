package com.cactt4ck.bqe.frames;

import com.cactt4ck.bqe.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class RootPanel extends JPanel {

    private JFrame rootFrame;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newItem, openItem, saveItem, closeItem, exitItem;
    private File file;
    private JLabel creditLabel;

    public RootPanel(LayoutManager layout, JFrame rootFrame) {
        this.setLayout(layout);
        this.rootFrame = rootFrame;

        this.initMenuBar();
        this.initCredits();
    }

    private void initMenuBar() {
        this.menuBar = new JMenuBar();

        this.fileMenu = new JMenu("File");

        this.newItem = new JMenuItem("New");
        this.newItem.addActionListener(al -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                this.file = fileChooser.getSelectedFile();
                System.out.println(this.file.getPath());
                Utils.initQuest(this.file);
                JOptionPane.showMessageDialog(
                        this,
                        "Source files generated!",
                        "Directory initialized",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        this.openItem = new JMenuItem("Open");
        this.openItem.addActionListener(al -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                this.file = fileChooser.getSelectedFile();
                System.out.println(this.file.getPath());
                if (!Utils.initDirectory(this.file))
                    JOptionPane.showMessageDialog(
                            this,
                            "Required files are missing!\nGenerating them...",
                            "Directory content invalid",
                            JOptionPane.INFORMATION_MESSAGE
                    );
            }
        });

        this.saveItem = new JMenuItem("Save");
        this.saveItem.setEnabled(false);

        this.closeItem = new JMenuItem("Close");
        this.closeItem.setEnabled(false);

        this.exitItem = new JMenuItem("Exit");
        this.exitItem.addActionListener(al -> this.rootFrame.dispose());

        this.fileMenu.add(this.newItem);
        this.fileMenu.add(this.openItem);
        this.fileMenu.add(this.saveItem);
        this.fileMenu.addSeparator();
        this.fileMenu.add(this.closeItem);
        this.fileMenu.add(this.exitItem);

        this.menuBar.add(fileMenu);

        this.add(this.menuBar, BorderLayout.NORTH);
    }

    private void initCredits() {
        this.creditLabel = new JLabel("By CacTt4ck");
        this.creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.creditLabel, BorderLayout.SOUTH);
    }

}
