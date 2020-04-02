import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO {

    Connection conn;


    public DepartmentDAO(){
        try {
            this.conn = new DBManager().getDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



public DepartmentDTO getSingleDepartmentByID(int id){
        DepartmentDTO departmentToReturn = new DepartmentDTO();
    try {
        PreparedStatement singledeparmentStatement = conn.prepareStatement("select * from dept where deptno =?");
        singledeparmentStatement.setInt(1,id);
        ResultSet singledeparment = singledeparmentStatement.executeQuery();

        while(singledeparment.next()){
            departmentToReturn.setDeptno(singledeparment.getInt("deptno"));
            departmentToReturn.setDeptno(singledeparment.getInt("dname"));
            departmentToReturn.setDeptno(singledeparment.getInt("loc"));

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return departmentToReturn;

}

}
