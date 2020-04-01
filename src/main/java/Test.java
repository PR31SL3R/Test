import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

public class Test {
    String result = "";
    InputStream inputStream;
    String URL;
    String USER;
    String PASSWORD;


    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


            // get the property value and print it out
             URL = prop.getProperty("URL");
             USER = prop.getProperty("USER");
             PASSWORD = prop.getProperty("PASSWORD");


            result = "URL = " + URL + ", " + USER + ", " + PASSWORD;
            System.out.println(result);



        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

        return result;
    }



    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.getPropValues();
    }
}