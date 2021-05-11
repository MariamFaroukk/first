package Wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader
{
	//leh static 3ashan kolo yshof nafs el makn
	//aw msh apass we a3mel constructor fe kol mara 
	//aw m3lmes object mno fe kol mara
	//propfile
	static String propertiesFilePath="Config.properties";
        //instance from properties 
// lessa ma3mltesh linking
	private static Properties properties= new Properties();
	// de awel haga bett3mel (static)
	static
	{

                //files bett2rey as stream of strings
               //try and catch 3ashan omken myt2resh
		FileInputStream propertiesFile=null;
		try {
			propertiesFile= new FileInputStream(propertiesFilePath);
                        //bet7wel el kalam lw key value 

			properties.load(propertiesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//bet7sel fy aywad3 pass or fail
		finally {
			try {
// close that stram momken y2ra in runtime
				propertiesFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        // 3ashan bardo ay 7etta y2raha
	//3ashan matb2ash esmclass.propfile.getvalue 
	
	public static String getValue(String key)
	{
		try{
			return properties.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

	}

}