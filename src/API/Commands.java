package src.API;

import src.GUI.PanelWork;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.sql.SQLException;
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
    public Help             exHelp = new Help();
    // ===================================================================================
    DataModel dm = null;
    DAL_Person dalPerson = null;
    public PanelWork pw = null;

    public Commands(DataModel dm) throws ParseException
    {
        this.dm = dm;
        try {
            dalPerson = new DAL_Person();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    // ===================================================================================
    class CreateListener implements ActionListener   // Listener for Button Create
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            InputDialog in = new InputDialog();  // Создаем новый класс extends JDialog для получения новой персоны
            in.setVisible(true);                // делаем видимым диалог
            try {
                dalPerson.create(in.getPerson()); // записываем в базу или файл новую персону
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            pw.table.updateUI();                  // Обновляем таблицу
            // show dialog
            // get data from dialog
            // dalPerson.create( p );
            // update view
        }
    }

    class ReadListener implements ActionListener  // Listener for Button Read
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dm.personList = dalPerson.read();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            pw.table.updateUI();
        }
    }

    class UpdateListener implements ActionListener  // Listener for Button Update data
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            InputDialog in = new InputDialog();  // Создаем новый класс extends JDialog для получения новой персоны
            in.setVisible(true);                // делаем видимым диалог
            try {
                dalPerson.update(in.getPerson()); // записываем в базу или файл новую персону
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            pw.table.updateUI();                  // Обновляем таблицу
            // show dialog
            // get data from dialog
            // dalPerson.update( p );
            // update view
        }
    }

    class DeleteListener implements ActionListener  // Listener for Button Delete
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = JOptionPane.showInputDialog(null, "Enter ID"); // Создаем диалог
            int idn = Integer.valueOf(id);                              // текстовое поле переводим в инт
            for (int i = 0; i < dm.personList.size(); i++)              // Создаем цикл в котором находим айди в листе соотв значению ид введенном в таблице
            {
                if (dm.personList.get(i).Id == idn) {
                    try {
                        dalPerson.delete(dm.personList.get(i));         //выполняем функцию делит
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            pw.table.updateUI();                                        // обновляем таблицу
            // show dialog
//            get data from dialog
//            dalPerson.delete( p );
//            update view
        }
    }

    // ===================================================================================
    class AboutListener implements ActionListener // Listener for Button About
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Данный функционал находиться в стадии реализации!!!");
        }
    }

    class FileExit implements ActionListener    // Listener for Button Exit
    {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Exit was correct !!!");
            System.exit(0);
        }
    }

    class Help implements ActionListener        // Listener for Button Help
    {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Функционал Help находится в стадии реализации!!!");
        }
    }

    class LangChoise implements ActionListener  // Listener for Button Choose lang. For Artem in future
    {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Функционал Смены языка находится в стадии реализации!!!");
        }
    }
}
