import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeDAO {

     Connection conn;
            /*
            Create Connection
             */

        public EmployeeDAO(){
            try {
                this.conn = new DBManager().getDBConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public HashMap getAllEmployees(Statement statement) throws SQLException {
        HashMap<String, EmployeeDTO> empMap = new HashMap<String, EmployeeDTO>();
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
            EmployeeDTO person = new EmployeeDTO(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next());
            empMap.put(person.empno, person);
        }
        return empMap;
    }

    public EmployeeDTO getsingleEmployee(int id){
        EmployeeDTO employeeToReturn = new EmployeeDTO();
        try {
            PreparedStatement singleEmployeeToReturn = conn.prepareStatement("select * from emp where emp.empno = ?");
            singleEmployeeToReturn.setInt(1,id);
            ResultSet singleEmployee = singleEmployeeToReturn.executeQuery();

            while(singleEmployee.next()){
                employeeToReturn.setEmpno(singleEmployee.getString("empno"));
                employeeToReturn.setEname(singleEmployee.getString("ename"));
                employeeToReturn.setMgr(singleEmployee.getString("mgr"));
                employeeToReturn.setHiredate(singleEmployee.getString("hiredate"));
                employeeToReturn.setSal(singleEmployee.getString("sal"));
                employeeToReturn.setComm(singleEmployee.getString("comm"));
                employeeToReturn.setDeptno(singleEmployee.getString("deptno"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeToReturn;

    }
}
