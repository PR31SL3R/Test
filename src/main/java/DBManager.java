import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    InputStream inputStream;

    public DBManager() {

        /*
        Connect to config.properties
         */
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*
        Connection Manager
         */
        this.URL = prop.getProperty("URL");
        this.USER = prop.getProperty("USER");
        this.PASSWORD = prop.getProperty("PASSWORD");

    }

    public Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
