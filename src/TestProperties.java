import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
/*
 * Use of the Properties class and FileReader to read the properties values.
 */
public class TestProperties {

	public static void main(String[] args) throws Exception{
		try{
			FileReader reader = new FileReader("D:/Dev/MyJavaProjects/src/db.properties");
			Properties p = new Properties();
			p.load(reader);

			System.out.println(p.getProperty("user"));
			System.out.println(p.getProperty("password"));

		}catch (FileNotFoundException e){
			System.out.println("Property file is not found.");
			return;
		}
	}
}
