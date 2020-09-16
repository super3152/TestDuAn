/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.ThongBaoLoi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takemikazuchi
 */
public class DBConnection {
     public static Connection conn;
 
    public static Connection getDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql://shopmart.fun/sho71306_shopmart","sho71306_duanshopmart","Duantotnghiep2020");
                System.out.println("Kết nối CSDL thành công");
               
                
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Kết nối CSDL thất bại");
                ThongBaoLoi.ThongBao("Lỗi kết nối, vui lòng kiểm tra lại đường truyền mạng", "Thông báo");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi kết nối ngoài ý muốn");
             ThongBaoLoi.ThongBao("Lỗi kết nối ngoài ý muốn", "Thông báo");
        }
    return conn;
    }
}
