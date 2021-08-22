package ml.noderyos.aromnialauncher;

import java.awt.*;
import javax.swing.*;

public class LauncherMain extends JFrame{

    public static void main(String[] args) throws Exception{
        new LauncherMain();
    }

    public LauncherMain() throws Exception{
        setSize(720,720);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setContentPane(new Interface());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}