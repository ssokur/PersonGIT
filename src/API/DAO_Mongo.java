package src.API;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Mongo  implements CRUD_Function
{

    /**** Connect to MongoDB ****/
    // Since 2.10.0, uses MongoClient
    MongoClient mongo;

    public DAO_Mongo() throws UnknownHostException
    {
        mongo = new MongoClient("localhost", 27017);
    }
// =================================================================================
    /**** Get database ****/
    // if database doesn't exists, MongoDB will create it for you
    DB db = mongo.getDB("testdb");

    /**** Get collection / table from 'testdb' ****/
    // if collection doesn't exists, MongoDB will create it for you
    DBCollection table = db.getCollection("person");
// =================================================================================

    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException
    {
        /**** Insert ****/
        // create a document to store key and value
        BasicDBObject document = new BasicDBObject();
        document.put("ID",      p.getId());
        document.put("FName",   p.getFName());
        document.put("LName",   p.getLName());
        document.put("Аge",     p.getAge());
        table.insert(document);
        System.out.println(table);
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException
    {
        /**** Find and display ****/
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("FName", "mkyong");
        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
        // need to chance signature
        return null;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException
    {

        DBCollection table = db.getCollection("person");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("FName", p);
        table.remove(searchQuery);
    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException
    {
        /**** Update ****/
        // search document where name="mkyong" and update it with new values
        BasicDBObject query = new BasicDBObject();
        query.put("FName", p.getFName());               // old data

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("FName", p);     // new data

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
    }
}
