package src.GUI;

import src.API.Person;
import src.Locale.Lockale;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class Data_Person
{
    public ResourceBundle res = null;
    public static ToolBar toolBar = null;
    public ArrayList<Person> current = null;

    public Data_Person()
    {

        new Lockale();
    }

    public void initLocale()
    {
        res = Lockale.initBundle();
    }

    public void initList(ArrayList<Person> currentIn)
    {
        current = currentIn;
    }

}
