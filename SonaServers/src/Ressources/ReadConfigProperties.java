package Ressources;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Properties;

public class ReadConfigProperties {

	public String getpropretyvalue(String filename,String propretykey) {
		String result="";
		InputStream input=getClass().getClassLoader().getResourceAsStream(filename);

			try {
			Properties property=new Properties();
			if (input!=null) {property.load(input);
			result=property.getProperty(propretykey);}
			else throw new FileNotFoundException("property File "+filename+" not found ");
			input.close();
         		} catch (IOException e) {
			e.printStackTrace();
         		}	
		
		return result;}
	
	public void setpropretyvalue(String filename,String propretykey,String newvalue) {
		
			Properties property=new Properties();
			
			try {
				InputStream input=getClass().getClassLoader().getResourceAsStream(filename);
				
				OutputStream out=new FileOutputStream(getClass().getClassLoader().getResource(filename).getPath(),true);
				property.load(input);
				property.setProperty(propretykey, newvalue);
				property.store(out,null);
			    out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
	
}
