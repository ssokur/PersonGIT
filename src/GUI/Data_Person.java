package src.GUI;

import src.Locale.Lockale;
import java.util.ResourceBundle;

public class Data_Person
{
    public ResourceBundle res = null;
    public static ToolBar toolBar = null;

    public Data_Person()
    {
        new Lockale();
        res = Lockale.initBundle();
    }
}
