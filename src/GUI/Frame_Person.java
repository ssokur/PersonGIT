package src.GUI;

import src.API.Commands;

import javax.swing.*;
import java.awt.*;

public class Frame_Person extends JFrame
{
    Main_Menu menu;
    ToolBar tBar;
    StatBar stBar;
    Commands comands;
    Data_Person data;
    PanelButton Pbtn;

    public Frame_Person() {

        data = new Data_Person();
        comands = new Commands();
        menu = new Main_Menu(comands);
        tBar = new ToolBar(comands);
        stBar = new StatBar(comands);
        Pbtn = new PanelButton(comands);

        initJFrame(data.res.getString("PersTitlle.Title"));

        setJMenuBar(menu);
        add(tBar, BorderLayout.NORTH);
        add(stBar);

        setVisible(true);
    }

    private void initJFrame(String titleIn) {
        setLayout(new BorderLayout());
        setTitle(titleIn);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(460, 420));
        pack();
        setLocationRelativeTo(null);
    }
}
