package src.API;

public class DAL_Person
{
    public DAL_Person()
    {
        new DAO_SQL();
        new DAO_Mongo();
        new DAO_JSON();
        new DAO_XML();
    }

}
