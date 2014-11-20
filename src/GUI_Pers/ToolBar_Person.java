        package src.GUI_Pers;

        import javax.swing.*;

public class ToolBar_Person extends JToolBar
{
    public ToolBar_Person(Data_Person dataIn, Command_Person comandsIn)
    {
        JButton     TSQL    =   new JButton(dataIn.res.getString("PersTitlle.iOper_SQL"));
        JButton     TMon    =   new JButton(dataIn.res.getString("PersTitlle.iOper_Mongo"));
        JButton     TJSON   =   new JButton(dataIn.res.getString("PersTitlle.iOper_JSON"));
        JButton     TXML    =   new JButton(dataIn.res.getString("PersTitlle.iOper_XML"));
        JButton     TExit   =   new JButton(dataIn.res.getString("PersTitlle.iOper_Exit"));

        add(TSQL);
        add(TMon);
        add(TJSON);
        add(TXML);
        add(TExit);

        TSQL. setToolTipText(dataIn.res.getString("PersTitlle.iOper_SQL"));
        TMon. setToolTipText(dataIn.res.getString("PersTitlle.iOper_Mongo"));
        TJSON.setToolTipText(dataIn.res.getString("PersTitlle.iOper_JSON"));
        TXML. setToolTipText(dataIn.res.getString("PersTitlle.iOper_XML"));
        TExit.setToolTipText(dataIn.res.getString("PersTitlle.iOper_Exit"));

        TSQL.addActionListener(comandsIn.actionSQL);
        TMon.addActionListener(comandsIn.actionMongo);
        TJSON.addActionListener(comandsIn.actionJSON);
        TXML.addActionListener(comandsIn.actionXML);
        TExit.addActionListener(comandsIn.actionExit);
    }
}

