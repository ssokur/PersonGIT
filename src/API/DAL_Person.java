package src.API;

import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_Person
{
    DAL_Person pd = null;

    public DAL_Person()
    {
//        new DAO_SQL();
//        new DAO_Mongo();
//        new DAO_JSON();
        new DAO_XML();
    }

    void create(Person p) throws SQLException, ClassNotFoundException
    {
        pd.create(p);
    }

    public ArrayList<Person> readall() throws SQLException, ClassNotFoundException
    {
        return pd.read();
    }

    private Person read()
    {
        return pd.read();
    }

    void delete(Person p) throws SQLException, ClassNotFoundException
    {
        pd.delete(p);
    }

    void update(Person p) throws SQLException, ClassNotFoundException
    {
        pd.update(p);
    }
}
