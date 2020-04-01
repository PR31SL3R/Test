public class Person {

    String empno;
    String ename;
    String job;
    String mgr;
    String hiredate;
    String sal;
    String comm;
    String deptno;

    public Person(String empno, String ename, String job, String mgr, String hiredate, String sal, String comm, String deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Person() {

    }
}