/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.ThongBaoLoi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Takemikazuchi
 */
public class DBConection {



    private static String DB_URL = "jdbc:mysql://shopmart.fun/sho71306_ChauNganProject";   
    private static String USER_NAME = "sho71306_Adminchaungan";
    private static String PASSWORD = "Duanchaungan2020";
    public static Connection conn;


    public void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi , thiếu thư viện kết nối");
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối CSDL" + ex);
        }

    }

    public static ResultSet GetData(String cauTruyVan) {
        try {
             conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cauTruyVan);
            System.out.println("1213213");
            return rs;
        } catch (SQLException ex) {
            System.out.println("lỗi lấy dữ liệu " + ex);
            return null;
        }
    }
    public static int ExcuteTruyVan(String cauTruyVan) {
        try {
             conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stm = conn.createStatement();
            int kq = stm.executeUpdate(cauTruyVan);
            return kq;
        } catch (SQLException ex) {
            System.out.println("Lỗi Thực Thi lệnh SQL");
            return -1;
        }
    }

    public void disconnect(){
        try {
            conn.close();
            System.out.println("disconect");
        } catch (SQLException ex) {
            Logger.getLogger(DBConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
