package src.GUI;

import src.API.Commands;

import javax.swing.*;

public class Main_Menu extends JMenuBar
{
    public Main_Menu(Data_Person dataIn, Commands comandsIn)
    {
        JMenu       mOper      		= new JMenu 	(dataIn.res.getString("PersTitlle.Oper"));
        JMenuItem   miOper_SQL  	= new JMenuItem (dataIn.res.getString("PersTitlle.iOper_SQL"));
        JMenuItem   miOper_Mongo  	= new JMenuItem (dataIn.res.getString("PersTitlle.iOper_Mongo"));
        JMenuItem   miOper_JSON     = new JMenuItem (dataIn.res.getString("PersTitlle.iOper_JSON"));
        JMenuItem   miOper_XML  	= new JMenuItem (dataIn.res.getString("PersTitlle.iOper_XML"));
        JMenuItem   miOper_Exit  	= new JMenuItem (dataIn.res.getString("PersTitlle.iOper_Exit"));

        JMenu       mHelp      		= new JMenu     (dataIn.res.getString("PersTitlle.Help"));
        JMenuItem   miHelp_Help     = new JMenuItem (dataIn.res.getString("PersTitlle.iHelp_Help"));
        JMenuItem   miHelp_About    = new JMenuItem (dataIn.res.getString("PersTitlle.iHelp_About"));

        //
        mOper.add(miOper_SQL);
        mOper.add(miOper_Mongo);
        mOper.add(miOper_JSON);
        mOper.add(miOper_XML);
        mOper.add(miOper_Exit);
        add(mOper);

        mHelp.add(miHelp_Help);
        mHelp.add(miHelp_About);
        add(mHelp);

        //
        miOper_SQL.  setAccelerator(KeyStroke.getKeyStroke("ctrl 1"));
        miOper_Mongo.setAccelerator(KeyStroke.getKeyStroke("ctrl 2"));
        miOper_JSON. setAccelerator(KeyStroke.getKeyStroke("ctrl 3"));
        miOper_XML.  setAccelerator(KeyStroke.getKeyStroke("ctrl 4"));

        miOper_SQL.addActionListener(comandsIn.actionSQL);
        miOper_Mongo.addActionListener(comandsIn.actionMongo);
        miOper_JSON.addActionListener(comandsIn.actionJSON);
        miOper_XML.addActionListener(comandsIn.actionXML);
        miOper_Exit.addActionListener(comandsIn.actionExit);

        miHelp_About.addActionListener(comandsIn.actionAbout);
        miHelp_Help.addActionListener(comandsIn.actionHelp);
    }
}
