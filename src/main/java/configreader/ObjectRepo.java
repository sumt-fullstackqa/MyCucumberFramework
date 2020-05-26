package configreader;


public class ObjectRepo extends PropertyFileReader{

	public static ConfigReader reader = new PropertyFileReader();
	
	public static void main (String args[])
	{
	PropertyFileReader obj=new PropertyFileReader();
	String url = obj.getUrl();
	System.out.println(url);
	
	}
}