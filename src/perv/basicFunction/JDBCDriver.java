package perv.basicFunction;

import java.sql.*;

public class JDBCDriver {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //手写一个JDBC连接
        //加载驱动
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        //获得一个连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        //sql语句
        String sql = "select * from table1";
        String sqlParam = "insert into table values(?,?,?)";
        //statement对象
        Statement statement = connection.createStatement();
        //
        //带参数的sql语句执行
        //PreparedStatement statement1 = connection.prepareStatement(sqlParam);
        //statement1.setInt(1,1);
        //statement1.setString(2,"name");
        //statement1.setDouble(3,1);
        //执行
        ResultSet resultSet = statement.executeQuery(sql);
        //带参的sql语句
        String sql2 = "select * from table1 where id={}";
        //

        //关闭(倒着关闭)
        resultSet.close();
        statement.close();
        connection.close();
    }
    public volatile static Integer int1;

}
