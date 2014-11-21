package src.API;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {
    DataModel dm = null;

    public PersonTableModel(DataModel dm) {
        this.dm = dm;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id()";
            case 1:
                return "FName()";
            case 2:
                return "LName()";
            case 3:
                return "Age()";

        }
        return "";
    }

    @Override
    public int getRowCount() {
        return dm.personList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person bean = dm.personList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getId();
            case 1:
                return bean.getFName();
            case 2:
                return bean.getLName();
            case 3:
                return bean.getAge();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }
}
