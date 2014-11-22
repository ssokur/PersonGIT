        package src.GUI;

        import src.API.Commands;

        import javax.swing.*;

public class ToolBar extends JToolBar
{
    public ToolBar(Commands cmd)
    {
        JButton TCreate     = new JButton("Create");
        JButton TRead       = new JButton("Read");
        JButton TUpdate     = new JButton("Update");
        JButton TDelete     = new JButton("Delete");

        add(TCreate);
        add(TRead);
        add(TUpdate);
        add(TDelete);

        TCreate.    addActionListener(cmd.evCreate);
        TRead.      addActionListener(cmd.evRead);
        TUpdate.    addActionListener(cmd.evUpdate);
        TDelete.    addActionListener(cmd.evDelete);
    }
}

