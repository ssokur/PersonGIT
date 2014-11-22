package src.API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAO_JSON implements CRUD_Function {
    ArrayList<Person> pp = new ArrayList<Person>();

    public DAO_JSON() {
        JSONParser parser = new JSONParser();
        JSONObject a = null;
        try {
            a = (JSONObject) parser.parse(new FileReader("\\file2.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray id = (JSONArray) a.get("Id");
        JSONArray fname = (JSONArray) a.get("FName");
        JSONArray lname = (JSONArray) a.get("LName");
        JSONArray age = (JSONArray) a.get("Age");
        for (int i = 0; i < id.size(); i++) {
            Person p = new Person();
            int idn2 = Integer.parseInt(String.valueOf(id.get(i)));
            p.setId(idn2);
            p.setFName((String) fname.get(i));
            p.setLName((String) lname.get(i));
            int agn2 = Integer.parseInt(String.valueOf(age.get(i)));
            p.setAge(agn2);
            pp.add(p);

        }
    }

    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException {
        Person person = new Person();
        person.setId(p.getId());
        person.setFName(p.getFName());
        person.setLName(p.getLName());
        person.setAge(p.getAge());
        pp.add(p);
        toFile();
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException {
        return pp;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException {
        int Idd = p.getId();
        for (int i = 0; i < pp.size(); i++) {
            if (pp.get(i).getId() == Idd) {
                pp.remove(i);
            }
        }
        toFile();
    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException {
        Person person = new Person();
        person.setId(p.getId());
        person.setFName(p.getFName());
        person.setLName(p.getLName());
        person.setAge(p.getAge());
        int Idd = p.getId();
        for (int i = 0; i < pp.size(); i++) {
            if (pp.get(i).getId() == Idd) {
                pp.set(i, person);
            }
        }
        toFile();
    }

    public String toFile() {
        JSONObject obj = new JSONObject();
        JSONArray Id = new JSONArray();
        JSONArray FName = new JSONArray();
        JSONArray LName = new JSONArray();
        JSONArray Age = new JSONArray();
        for (int i = 0; i < pp.size(); i++) {
            Id.add(pp.get(i).getId());
            FName.add(pp.get(i).getFName());
            LName.add(pp.get(i).getLName());
            Age.add(pp.get(i).getAge());
        }
        obj.put("Id", Id);
        obj.put("FName", FName);
        obj.put("LName", LName);
        obj.put("Age", Age);
        try {
            FileWriter file = new FileWriter("d:\\file2.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
