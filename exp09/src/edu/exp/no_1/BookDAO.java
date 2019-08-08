package edu.exp.no_1;

import java.sql.*;

public class BookDAO{
    Connection conn =null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;

    public BookDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();   //jar包
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据书号查询图书信息
    public BookBean searchBook(String bookid){
        BookBean book = new BookBean();
        try{
            pstmt = conn.prepareStatement("SELECT * FROM book WHERE bookid=?");
            pstmt.setString(1,bookid);
            rst = pstmt.executeQuery();
            if(rst.next()){
                book.setBookid(rst.getString("bookid"));
                book.setTitle(rst.getString("title"));
                book.setAuthor(rst.getString("author"));
                book.setPublisher(rst.getString("publisher"));
                book.setPrice(rst.getFloat("price"));
                return book;
            }else{
                return  null;
            }
        }catch(SQLException se){
            return null;
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
            }
        }
    }
    // 插入一本图书记录
    public boolean insertBook(BookBean book){
        try{
            pstmt = conn.prepareStatement("INSERT INTO book VALUES(?,?,?,?,?)");
            pstmt.setString(1,book.getBookid());
            pstmt.setString(2,book.getTitle());
            pstmt.setString(3,book.getAuthor());
            pstmt.setString(4,book.getPublisher());
            pstmt.setFloat(5,book.getPrice());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        }catch(SQLException se){
            return false;
        }finally{
            try{
                conn.close();
            }catch(SQLException se){ }
        }
    }
}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class BookDAO {
////instance.setUrl("jdbc:mysql://localhost:3306/MyEverything?useUnicode=true&characterEncoding=utf-8&useSSL=false");
////instance.setUsername("root");
//// instance.setPassword("123456");
////instance.setDriverClassName("com.mysql.jdbc.Driver");
//    public static void main(String[] args) {
//        //声明Connection对象
//        Connection con;
//        //驱动程序名
//        String driver = "com.mysql.jdbc.Driver";
//        //URL指向要访问的数据库名mydata
//        String url = "jdbc:mysql://localhost:3306/test";
//        //MySQL配置时的用户名
//        String user = "root";
//        //MySQL配置时的密码
//        String password = "123456";
//        //遍历查询结果集
//        try {
//            //加载驱动程序
//            Class.forName(driver);
//            //1.getConnection()方法，连接MySQL数据库！！
//            con = DriverManager.getConnection(url,user,password);
//            if(!con.isClosed())
//                System.out.println("Succeeded connecting to the Database!");
//            //2.创建statement类对象，用来执行SQL语句！！
//            Statement statement = con.createStatement();
//            //要执行的SQL语句
//            String sql = "select * from books";
//            //3.ResultSet类，用来存放获取的结果集！！
//            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("-----------------");
//            System.out.println("执行结果如下所示:");
//            System.out.println("-----------------");
//            //System.out.println("姓名" + "\t" + "职称");
//            System.out.println("-----------------");
//
//            String job = null;
//            String id = null;
//            while(rs.next()){
//                //获取stuname这列数据
//                job = rs.getString("job");
//                //获取stuid这列数据
//                id = rs.getString("ename");
//
//                //输出结果
//                System.out.println(id + "\t" + job);
//            }
//            rs.close();
//            con.close();
//        } catch(ClassNotFoundException e) {
//            //数据库驱动类异常处理
//            System.out.println("Sorry,can`t find the Driver!");
//            e.printStackTrace();
//        } catch(SQLException e) {
//            //数据库连接失败异常处理
//            e.printStackTrace();
//        }catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }finally{
//            System.out.println("数据库数据成功获取！！");
//        }
//    }
//
//}