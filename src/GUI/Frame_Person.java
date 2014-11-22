package src.GUI;

import src.API.Commands;
import src.API.DataModel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class Frame_Person extends JFrame
{
    Main_Menu menu;
    ToolBar tBar;
    StatBar stBar;
    Commands comands;
    Data_Person data;
    PanelButton Pbtn;
    DataModel dataModel;

    public Frame_Person() throws ParseException {
        dataModel = new DataModel();
        data = new Data_Person();
        comands = new Commands(dataModel);
        menu = new Main_Menu(comands);
        tBar = new ToolBar(comands);
        stBar = new StatBar(comands);
        Pbtn = new PanelButton(comands);

        initJFrame(data.res.getString("PersTitlle.Title"));

        add(Pbtn, BorderLayout.AFTER_LAST_LINE);

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
