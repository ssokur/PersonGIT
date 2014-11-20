package API;

public class Person 
{
	public int Id;
	public String FName;
	public String LName;
	public int Age;

	public Person(int id, String fName, String lName, int age)	
	{	
		this.Id = id;
		FName = fName;
		LName = lName;
		Age = age;
	}
	
	public int 		getId() 
	{
		return Id;
	}
	public void 	setId(int id) 
	{
		Id = id;
	}
	public String 	getFName() 
	{
		return FName;
	}
	public void 	setFName(String fName) 
	{
		FName = fName;
	}
	public String 	getLName() 
	{
		return LName;
	}
	public void 	setLName(String lName) 
	{
		LName = lName;
	}
	public int 		getAge() 
	{
		return Age;
	}
	public void 	setAge(int age) 
	{
		Age = age;
	}
}