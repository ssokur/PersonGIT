package src.API;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_XML implements CRUD_Function
{
    ArrayList<Person> pp = new ArrayList<Person>();

    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException {
        //Source domSource = new DOMSource();
        XMLEncoder xml = null;
        try {
            xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("\"d:\\Programs Data\\IntelliJ\\Person\\TestXML.xml")));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        xml.writeObject(pp);
        xml.close();
        System.out.println(pp);
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException {
        XMLDecoder xml = null;
        try {
            xml = new XMLDecoder(new BufferedInputStream(new FileInputStream("TestXML.xml")));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        ArrayList<Person> pp = (ArrayList<Person>) xml.readObject();
        xml.close();
        // updateUI

        return null;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException {
        //        int Idd = p.getId();
//        for (int i = 0; i < pp.size(); i++)
//        {
//            if (pp.get(i).getId() == Idd)
//            {
//                pp.remove(i);
//            }
//        }
    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException

    {
//        int Idd = p.getId();
//        for (int i = 0; i < pp.size(); i++)
//        {
//            if (pp.get(i).getId() == Idd)
//            {
//
//            }
//        }
    }
}
