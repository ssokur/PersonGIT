package src.GUI;

import src.API.Commands;
import src.API.DataModel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class Frame_Person extends JFrame
{
    Main_Menu menu;         // init main mane
    ToolBar tBar;           // init toolbar
    StatBar stBar;          // init Status Bar
    Commands comands;       // init class with commands
    Data_Person data;       // init class with structure Person ArrayList
    PanelButton Pbtn;       // init panel for 4 buttons
    DataModel dataModel;    // init class with ArrayList structure
    PanelWork tablePerson;  // init table for data

    public Frame_Person() throws ParseException
    {
        dataModel       = new DataModel();
        data            = new Data_Person();
        comands         = new Commands(dataModel);
        menu            = new Main_Menu(comands);
        tBar            = new ToolBar(comands);
        stBar           = new StatBar(comands);
        Pbtn            = new PanelButton(comands);

        tablePerson     = new PanelWork(dataModel);
        comands.pw      = tablePerson;

        add(tablePerson, BorderLayout.CENTER);      // add panel with table data
        add(Pbtn, BorderLayout.AFTER_LAST_LINE);    // add panel with buttons
        add(tBar, BorderLayout.BEFORE_FIRST_LINE);  // add panel with toolBar

        setJMenuBar(menu);
        setPreferredSize(new Dimension(600, 600));
        pack();
        setDefaultCloseOperation(Frame_Person.EXIT_ON_CLOSE);
        setVisible(true);

//        initJFrame(data.res.getString("PersTitlle.Title"));
    }

//    private void initJFrame(String titleIn) {
//        setLayout(new BorderLayout());
//        setTitle(titleIn);
//        setDefaultLookAndFeelDecorated(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setPreferredSize(new Dimension(460, 420));
//        pack();
//        setLocationRelativeTo(null);
//    }
}
