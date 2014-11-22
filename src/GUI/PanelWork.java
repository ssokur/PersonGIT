package src.GUI;

import src.API.DataModel;
import src.API.PersonTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;

public class PanelWork extends JPanel {
    TableModel model = null;
    JTable table;

    public PanelWork(DataModel dm) {
        model = new PersonTableModel(dm);
        table = new JTable(model);
        add(new JScrollPane(table));
    }

}
