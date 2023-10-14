package org.main;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.UIScale;
import org.forms.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main  extends JFrame {
    private Home home;
    public Main() {

        init();
    }

    private void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setSize(UIScale.scale(new Dimension(1365, 768)));
        setLocationRelativeTo(null);
        home = new Home();
        setContentPane(home);

        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                home.play();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                home.stop();
            }
        });
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatMacDarkLaf.setup();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

}