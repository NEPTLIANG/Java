package Operation;

import java.sql.*;

public class SQL {
    String url;
    Connection conn;
    Statement stmt;

    public SQL() /*throws SQLException*/ {
        try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //加载MS SQL Server的JDBC驱动程序
        } catch (ClassNotFoundException e) {  //可能抛出ClassNotFoundException异常
            System.out.printf("ClassNotFoundException");
        }

        url = "jdbc:sqlserver://localhost:1433;DatabaseName=mytest1";  //设置连接的url参数
        try {
            conn = DriverManager.getConnection(url, "test", "test");  //创建连接，每次启动IDEA都要导入一次jdbc驱动
            stmt = conn.createStatement();  //创建Statement对象
//        stmt.executeUpdate("CREATE TABLE Test(name char(20))");  //执行增删改语句
        } catch (SQLException e) {
        }
    }
}

class SQLLogin extends SQL {
    public boolean login(String idIpnut, String pwdInput) throws SQLException {
        String sqlLogin = "SELECT * FROM UserTable";
        ResultSet rs = stmt.executeQuery(sqlLogin);
        while (rs.next()) {
            String id = rs.getString("id");
            String pwd = rs.getString("pwd");
            if (idIpnut.equals(id) && pwdInput.equals(pwd)) {  //字符串要用equals判等而不能直接用==
                return true;
            }
        }
        return false;
    }
}

class SQLCourseQuery extends SQL {
    public String sqlCourseQuery() throws SQLException {
        String sql = "SELECT student.sname, score.sno, course.cname, score.cno " +
                "FROM (score JOIN course ON score.cno=course.cno) JOIN student ON score.sno=student.sno " +
                "WHERE score.sno=" + GUI.id;
        ResultSet rs = stmt.executeQuery(sql);
        String sname, cname, sno, cno, result="<html><body>";
        int grade;
        while (rs.next()) {
            sname = rs.getString("sname");
            cname = rs.getString("cname");
            sno = rs.getString("sno");
            cno = rs.getString("cno");
            result += (sname + "," + sno + "," + cname + "," + cno + "<br/>");
        }
        return (result+"</body></html>");
    }
}