import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Employee extends Person {

    public Employee() {
        super();

    }

    public HashMap getAllEmployees(Statement statement) throws SQLException {

        HashMap<String, Person> empMap = new HashMap<String, Person>();
        ResultSet query1 = statement.executeQuery("select * from emp");
        ResultSetMetaData meta = query1.getMetaData();
        int getColumnCount = meta.getColumnCount();

        while (query1.next()) {
            String results = "";
            for (int i = 1; i <= getColumnCount; i++) {

                if (null == query1.getString(i)) {
                    results += "null ";
                } else {
                    results += query1.getString(i) + " ";
                }
            }

            Scanner scan = new Scanner(results);
            Person person = new Person(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next());
            empMap.put(person.empno, person);
        }
        return empMap;
    }

}