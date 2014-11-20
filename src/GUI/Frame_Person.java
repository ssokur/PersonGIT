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

        public Frame_Person() {
            data = new Data_Person();
            comands = new Commands();
            initJFrame(data.res.getString("PersTitlle.Title"));

            menu = new Main_Menu(data, comands);

            tBar = new ToolBar(data, comands);
            stBar	= new StatBar(comands);

            setJMenuBar(menu);
            add(tBar, BorderLayout.NORTH);
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
