import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        //connect
        try {

            /*
            Create Connection
             */

            DBManager manager = new DBManager();
            Connection sqlConnectManager = manager.getDBConnection();
            Statement sqlConnection = sqlConnectManager.createStatement();

            /*
             SQL Query
             */

            ResultSet query1 = sqlConnection.executeQuery("select * from emp");

            ResultSetMetaData meta = query1.getMetaData();
            int getColumnCount = meta.getColumnCount();
            String queryResult = "";

            for (int i = 1; i < getColumnCount; i++) {
                queryResult += meta.getColumnName(i) + " ";
            }
            queryResult += "\n";
            while (query1.next()) {
                for (int i = 1; i < getColumnCount; i++) {
                    queryResult += query1.getString(i) + " ";

                }
                queryResult += "\n";
            }
            System.out.println(queryResult);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
