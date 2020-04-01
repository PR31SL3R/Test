import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    String result = "";
    InputStream inputStream;


    public DBManager(){



        /*
        Connection Manager
         */
        this.URL = "jdbc:mysql://localhost:3306/emp_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.USER = "root";
        this.PASSWORD = "12345678";

    }

    public Connection getDBConnection()throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}
