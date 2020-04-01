
import java.sql.*;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws SQLException {
        //connect
        Connection sqlConnectManager;
        try {

            /*
            Create Connection
             */

            DBManager manager = new DBManager();
            sqlConnectManager = manager.getDBConnection();
            Statement sqlConnection = sqlConnectManager.createStatement();

            /*
             SQL Query 1
             */
            ResultSet query1 = sqlConnection.executeQuery("select * from dept");
            while (query1.next()) {
                System.out.println(query1.getString("deptno"));
            }
            /*
             SQL Query 2
             */

            ResultSet query2 = sqlConnection.executeQuery("select * from emp");

            ResultSetMetaData meta = query2.getMetaData();
            int getColumnCount = meta.getColumnCount();
            String queryResult = "";

            for (int i = 1; i < getColumnCount; i++) {
                queryResult += meta.getColumnName(i) + " ";
            }
            queryResult += "\n";
            while (query2.next()) {
                for (int i = 1; i < getColumnCount; i++) {
                    queryResult += query2.getString(i) + " ";

                }
                queryResult += "\n";
            }
            System.out.println(queryResult);


            /*
            Excercise HashMap -
            *Bemærk at vi har arbejdet sammen med: Jakob Bundgaard, Christian og Christian*

             */

            Employee emp = new Employee();

            HashMap<String, Object> map = new HashMap<String, Object>();
            map = emp.getAllEmployees(sqlConnectManager.createStatement());
            for (Object key : map.values()) {
                System.out.println(key);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
