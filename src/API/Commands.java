package src.API;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Commands
{
    public ToSQL      	actionSQL      	= new ToSQL();
    public ToMongo    	actionMongo     = new ToMongo();
    public ToJSON      	actionJSON      = new ToJSON();
    public ToXML      	actionXML      	= new ToXML();
    public ToExit      	actionExit      = new ToExit();
    public LangChoise  	actionLang      = new LangChoise();
    public About 		actionAbout  	= new About();
    public Help 		actionHelp  	= new Help();

    class ToSQL implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал SQL находится в стадии реализации!!!");
        }
    }
    class ToMongo implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал Mongo находится в стадии реализации!!!");
        }
    }
    class ToJSON implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал JSON находится в стадии реализации!!!");
        }
    }
    class ToXML implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал XML находится в стадии реализации!!!");
        }
    }
    class ToExit implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Корректный выход Exit !!!");
            System.exit(0);
        }
    }
    class About implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал About находится в стадии реализации!!!");
        }
    }
    class Help implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал Help находится в стадии реализации!!!");
        }
    }
    class LangChoise implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Функционал Смены языка находится в стадии реализации!!!");
        }
    }
}
