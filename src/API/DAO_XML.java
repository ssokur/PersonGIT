package src.API;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_XML implements CRUD_Function
{
    ArrayList<Person> pp = new ArrayList<Person>();

    DAO_XML()
    {
        try {
            File fXmlFile = new File("Library\\data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Person");
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    Person p = new Person();
                    int idn2 = Integer.parseInt(eElement.getAttribute("id"));
                    p.setId(idn2);
                    p.setFName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    p.setLName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    int agn2 = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
                    p.setAge(agn2);
                    pp.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException
    {
        Person person = new Person();
        person.setId(p.getId());
        person.setFName(p.getFName());
        person.setLName(p.getLName());
        person.setAge(p.getAge());
        pp.add(p);
        toFile();
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException
    {
        return pp;
    }
    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException
    {
        int Idd = p.getId();
        for (int i = 0; i < pp.size(); i++)
        {
            if (pp.get(i).getId() == Idd)
            {
                pp.remove(i);
            }
        }
        toFile();
    }
    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException
    {
        Person person = new Person();
        person.setId(p.getId());
        person.setFName(p.getFName());
        person.setLName(p.getLName());
        person.setAge(p.getAge());
        int Idd = p.getId();
        for (int i = 0; i < pp.size(); i++)
        {
            if (pp.get(i).getId() == Idd)
            {
                pp.set(i, p);
            }
        }
        toFile();
    }
    public void toFile()
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Person_DAO");
        doc.appendChild(rootElement);
        for (int i = 0; i < pp.size(); i++)
        {
            // staff elements
            Element staff = doc.createElement("Person");
            rootElement.appendChild(staff);
            // set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue(String.valueOf(pp.get(i).getId()));
            staff.setAttributeNode(attr);
            // firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode(String.valueOf(pp.get(i).getFName())));
            staff.appendChild(firstname);
            // lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode(String.valueOf(pp.get(i).getLName())));
            staff.appendChild(lastname);
            // salary elements
            Element salary = doc.createElement("age");
            salary.appendChild(doc.createTextNode(String.valueOf(pp.get(i).getAge())));
            staff.appendChild(salary);
        }
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("Library\\data.xml"));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
