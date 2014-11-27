package src.API;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Hibernate implements CRUD_Function

{
    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException
    {
        org.hibernate.classic.Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
//            session.save(Person);
//            session.getTransaction().commit();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException
    {
        return null;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException
    {

    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException
    {

    }
}
