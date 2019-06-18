import java.sql.*;

public class Experiment11 {
    public static void main(String[] args) throws SQLException {
        try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //加载MS SQL Server的JDBC驱动程序
        } catch (ClassNotFoundException e) {  //可能抛出ClassNotFoundException异常
            System.out.printf("ClassNotFoundException");
        }

        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=myDB";  //设置连接的url参数
        Connection conn = DriverManager.getConnection(url, "test", "test");  //创建连接
        Statement stmt = conn.createStatement();  //创建Statement对象
        stmt.executeUpdate("CREATE TABLE Student");  //执行增删改语句
    }
}