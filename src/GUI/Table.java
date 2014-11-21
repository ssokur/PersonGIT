package src.GUI;

import src.API.Person;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Table extends AbstractTableModel
{
    private int size = 0;

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        switch (columnIndex)
        {
            case 0:
                return "Id";
            case 1:
                return "FName";
            case 2:
                return "LName";
            case 3:
                return "Age";

        }
        return "";
    }

    public int getRowCount()      // получить количество строк
    {
        return data.size();       // размер таблицы, количество строк
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Person p = data.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return p.Id;
            case 1:
                return p.FName;
            case 2:
                return p.LName;
            case 3:
                return p.Age;

        }
        return "";
    }
}
