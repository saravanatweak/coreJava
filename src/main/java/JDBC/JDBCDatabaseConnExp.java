package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDatabaseConnExp {
    public static void main(String args[]) throws Exception {
        //Connection to oracle database ( ojdbc<version>.jar is required to connect the app with db )
        new OracleConnExp().oracleConn();

        //Connection to mySql database  ( mysqlconnector.jar is required to connect the app with db )
        //new MySQLConnExp().mysqlCon();

}
}

class OracleConnExp {
    public void oracleConn() {
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle;thin;@localhost:1521:xe","system","oralce");

            //step3 create the statement object
            Statement st = con.createStatement();

            //step4 execute query
            ResultSet rs = st.executeQuery("Select * from dual");
            System.out.println(rs);

            //step5 close the connection
            con.close();
        } catch (Exception e) {System.out.println(); }
    }
}

class MySQLConnExp {
    public void mysqlCon() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}