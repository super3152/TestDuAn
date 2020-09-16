/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DBConnection.conn;
import GUI.ThongBaoLoi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takemikazuchi
 */
public class DBConection {
       private static  String hostName = "shopmart.fun";
    private static  String dbName = "sho71306_shopmart";
    private static  String userName = "sho71306_duanshopmart";
    private static  String password = "Duantotnghiep2020";
    // jdbc:mysql://hostname:port/dbname
    private static  String connectionURL = "jdbc:mysql://" + hostName + dbName + userName + password;
    
    public static Connection conn;

    public  DBConection() {
          
        try {            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());  
      Connection conn = DriverManager.getConnection(connectionURL);
//Kiểm tra kết nối
            if (conn != null) {
                 System.out.println("Kết nối CSDL thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi đăng ký JDBC." + ex.getMessage());
        }
       
        
     
}
    
    
    public static ResultSet GetData(String cauTruyVan) {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cauTruyVan);

            return rs;

        } catch (SQLException e) {
            System.out.println("Lỗi lấy dữ liệu");
            return null;
        }
    }
    
      public static int ExecuteTruyVan(String cauTruyVan) {
        try {
            Statement stm = conn.createStatement();
            int kq = stm.executeUpdate(cauTruyVan);
            return kq;

        } catch (SQLException ex) {
            System.out.println("Lỗi thực thi lệnh SQL");
            return -1;
        }
    }
}