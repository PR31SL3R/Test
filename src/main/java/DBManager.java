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
        Properties prop = null;
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.URL = prop.getProperty("URL");
        this.USER = prop.getProperty("USER");
        this.PASSWORD = prop.getProperty("PASSWORD");

    }

    /*
        Connection Manager
         */

    public Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
