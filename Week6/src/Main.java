

import java.sql.*;

public class Main {
    public static void main(String args[]) throws SQLException {
        ResultSet ans = null;
        try {
//            com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://localhost:3306/week5";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url,user,password);
//1
            Statement stmt = con.createStatement();
            String insetsql = "insert into  student(sno,name,age,College)values('s001','老大',20,'计算机学院'),('s002','老二',19,'计算机学院'),('s003','老三',18,'计算机学院'),('s004','老四',17,'计算机学院')";
            stmt.executeUpdate(insetsql);
            String query = "select * from student";
            ans = stmt.executeQuery(query);
//2
            while(ans.next()){
                String sno = ans.getString(1);
                String name =ans.getString(2);
                String age = ans.getString(3);
                String College = ans.getString(4);
                System.out.println(sno+','+name+','+age+','+College);
            }
//3
            String deletsql = "delete  from student where sno='s004'";
            stmt.executeUpdate(deletsql);

// 4

            String query_2 = "select * from student where sno='s003'";
            ans = stmt.executeQuery(query_2);
            while(ans.next()){
                String sno = ans.getString(1);
                String name =ans.getString(2);
                String age = ans.getString(3);
                String College = ans.getString(4);
                System.out.println(sno+','+name+','+age+','+College);
            }
//5
            String update ="update student set sno='s001',name='老大',age = 20,College='通信学院' where sno='s001'";


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
