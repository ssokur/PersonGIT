package src.API;

import src.GUI.PanelWork;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Commands
{
    public CreateListener   evCreate = new CreateListener();
    public ReadListener     evRead = new ReadListener();
    public UpdateListener   evUpdate = new UpdateListener();
    public DeleteListener   evDelete = new DeleteListener();
    public AboutListener    evAbout = new AboutListener();
    public FileExit         evExit = new FileExit();
    public LangChoise       exLang = new LangChoise();
    public About            exAbout = new About();
    public Help             exHelp = new Help();

    DataModel               dm = null;
    DAL_Person              dalPerson = null;
    public PanelWork        pw = null;

    public Commands(DataModel dm) throws ParseException
    {
        this.dm = dm;
        dalPerson = new DAL_Person();
    }

    class CreateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // show dialog
            // get data from dialog
            // dalPerson.create( p );
            // update view
        }
    }

    class ReadListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            dm.personList = dalPerson.read();
            System.out.println("Data readed");

        }
    }

    class UpdateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // show dialog
            // get data from dialog
            // dalPerson.update( p );
            // update view
        }
    }

    class DeleteListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // show dialog
            // get data from dialog
            // dalPerson.delete( p );
            // update view
        }
    }

    class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Данный функционал находиться в стадии реализации!!!");
        }
    }

    class FileExit implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Exit was correct !!!");
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
