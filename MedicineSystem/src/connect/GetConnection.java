//���ݿ�����
package connect;
import java.sql.*;
public class GetConnection {
        // public static void main(String []args) {
         String driverName;//="com.microsoft.sqlserver.jdbc.SQLServerDriver";
         String dbURL;//="jdbc:sqlserver://localhost:1433;DatabaseName=YPJXC";
         String userName;//="sa";
         String userPwd;//="991117";
         Connection dbConn;
         
         public GetConnection() {
			// TODO �Զ����ɵĹ��캯�����
        	 driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        	 dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=YPGL";
        	 userName="sa";
        	 userPwd="991117";
        	 this.getConnect();
		}
         public Connection getConn() {
        	 return dbConn;
         }
         
         
         public void getConnect() {
          try
        {
            Class.forName(driverName);
            dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("success!");
         }
          catch(Exception e)
       {
            e.printStackTrace();
            System.out.print("fail!");
       }
         }
    }
 //} 
