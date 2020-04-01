import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    public DBManager(){
        this.URL = "jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.USER = "root";
        this.PASSWORD = "12345678";

    }

    public Connection getDBConnection()throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
