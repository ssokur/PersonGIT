package GUI;

import API.Lockale_Person;

import java.util.ResourceBundle;

public class Data_Person

{
    public ResourceBundle res = null;
    public static ToolBar_Person toolBar = null;

    public Data_Person()
    {
        new Lockale_Person();
        res = Lockale_Person.initBundle();
    }
}