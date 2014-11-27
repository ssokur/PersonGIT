package src.API;

import org.hibernate.SessionFactory;

public class HibernateUtil

    // Класс HibernateUtil,
    // который будет отвечать за обработку xml файла hibernate.cfg.xml и установление соединения с нашей базой данных:

{
    private static SessionFactory sessionFactory = null;

    static
    {
        try
        {
            //creates the session factory from hibernate.cfg.xml
            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
