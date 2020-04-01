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
             Create Connection
             */

            ResultSet query3 = sqlConnection.executeQuery("select * from dept");

            ResultSetMetaData meta = query3.getMetaData();

            while(query3.next()){
                System.out.println(query3.getInt("deptno"));
                System.out.println(meta.getColumnCount());
            }


            ResultSet query1 = sqlConnection.executeQuery("use emp_db;");
            ResultSet query2 = sqlConnection.executeQuery("select empno from emp");


            DatabaseMetaData rfbdb = sqlConnectManager.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rst = rfbdb.getTables(null, null, "%", types);
            while (rst.next()) {
                System.out.println(rst.getString("TABLE_NAME"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
