package GUI;

import javax.swing.*;
import java.awt.*;

public class Frame_Person extends JFrame
{

    static General_Panel panel;
    static Menu_Person menu;
    static ToolBar_Person tBar;
    static StatBar_Person stBar;

    Command_Person comands;
    Data_Person data;

    public Frame_Person() {
        data = new Data_Person();
        comands = new Command_Person();
        initJFrame(data.res.getString("PersTitlle.Title"));

        menu = new Menu_Person(data, comands);

        tBar = new ToolBar_Person(data, comands);
        stBar	= new StatBar_Person(comands);
        panel 	= new General_Panel(stBar, comands);

        setJMenuBar(menu);
        add(tBar, BorderLayout.NORTH);
        add(panel);
        add(stBar);

        setVisible(true);
    }

    private void initJFrame(String titleIn)
    {
        setLayout(new BorderLayout());
        setTitle(titleIn);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(460, 420));
        pack();
        setLocationRelativeTo(null);
    }
}
