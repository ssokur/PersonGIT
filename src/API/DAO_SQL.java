package src.API;

import java.sql.*;
import java.util.ArrayList;

public class DAO_SQL implements CRUD_Function

{
//=============================================================================
// Connect to MySQL
//============================================================================

    String user = "root";                             //Логин пользователя
    String password = "80689574122";                  //Пароль пользователя
    String url = "jdbc:mysql://localhost/person";     //URL адрес
    String driver = "com.mysql.jdbc.Driver";          //Имя драйвера

    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException {
        Class.forName(driver);          //Регистрируем драйвер
        Connection c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
        Statement st = c.createStatement(); //Готовим запрос

        String sql = "INSERT INTO Person VALUES(" + p.getId() + ", '" + p.getFName() + "', '"
                + p.getLName() + "', " + p.getAge() + ")";
        System.out.println(sql);
        st.executeUpdate(sql);
        c.close();
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException {
        ArrayList<Person> pp = new ArrayList<Person>();
        Class.forName(driver);//Регистрируем драйвер
        Connection c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
        Statement st = c.createStatement();//Готовим запрос
        ResultSet rs = st.executeQuery("SELECT * FROM Person");//Выполняем запрос к БД, результат в переменной rs

        while (rs.next()) {
            Person p = new Person();
            p.setId(rs.getInt("Id"));
            p.setFName(rs.getString(2));
            p.setLName(rs.getString("LName"));
            p.setAge(rs.getInt(4));
            pp.add(p);
        }
        c.close();
        return pp;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException {
        Class.forName(driver);//Регистрируем драйвер
        Connection c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
        Statement st = c.createStatement();//Готовим запрос

        String sql = "UPDATE Person set FName='" + p.getFName() + "', LName='" + p.getLName() + "', " +
                "Age='" + p.getAge() + "' WHERE ID =" + p.getId() + ";";
        System.out.println(sql);
        st.executeUpdate(sql);
        c.close();
    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException {
        Class.forName(driver);//Регистрируем драйвер
        Connection c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
        Statement st = c.createStatement();//Готовим запрос

        String sql = "DELETE  FROM Person WHERE ID = (" + p.getId() + ")";
        System.out.println(sql);
        st.executeUpdate(sql);
        c.close();
    }
}
