package Ressources;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties {

	public String getpropretyvalue(String filename,String propretykey) {
		String result="";
		InputStream input=getClass().getClassLoader().getResourceAsStream(filename);
		
		try {
			Properties property=new Properties();
			if(input!=null) property.load(input);
			else {
			throw new FileNotFoundException("property File "+filename+" not found ");}
			result=property.getProperty(propretykey);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return result;}
	
	
	
	
	
}
