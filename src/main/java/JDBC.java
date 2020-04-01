import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        //connect
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfb_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","12345678");

            DBManager manager = new DBManager();
            Connection sqlConnect = manager.getDBConnection();
            Statement sql = sqlConnect.createStatement();
            ResultSet test1 = sql.executeQuery("use rfb_db;");
            ResultSet test2 = sql.executeQuery("select navn from børn");

            DatabaseMetaData rfbdb = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rst = rfbdb.getTables(null, null, "%", types);
            while (rst.next()) {
                System.out.println(rst.getString("TABLE_NAME"));

            }

            while (test2.next()){
                System.out.println(test2.getString("navn"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
