/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DBConection;
import GUI.ThongBaoLoi;
import GUI.ThongBaoCanhBao;
import GUI.ThongBaoThongTin;
import GUI.frmmain;
import GUI.jdllogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Takemikazuchi
 */
public class BLLlogin {
     public static Connection con;
   public static PreparedStatement pst;
   public static ResultSet rs;

   public static boolean login() {
      String username = GUI.jdllogin.txtUser.getText();
      String password = String.valueOf(GUI.jdllogin.txtPass.getPassword());
    
        if(username.equals("")||password.equals("")){
          ThongBaoCanhBao.ThongBao("Vui lòng nhập đầy đủ thông tin", "Thông báo");
           return false;
       }
          if (username.trim().length() > 15 || username.trim().length() < 5) {
            ThongBaoCanhBao.ThongBao("Username phải từ 5 đến 15 kí tự", "Thông báo lỗi");
            return false;
        }
        else{
           try{
               con = DBConection.getDatabase();
               //lấy dữ liệu bảng từ dattabase
               pst = con.prepareStatement("SELECT * FROM user WHERE tentaikhoan=? and matkhau=?");
               pst.setString(1, username);
               pst.setString(2, password);
               rs = pst.executeQuery();
               if(rs.next()){
                   ThongBaoThongTin.ThongBao("Đăng nhập thành công", "Thông báo");
                  return true;
                    
       
               }else{
                 ThongBaoLoi.ThongBao("Đăng nhập thất bại\n" +
                       "Sai tên đăng nhập hoặc mật khẩu;", "Thông báo");
                 return false;
               }
           }catch(Exception e){
                 ThongBaoLoi.ThongBao("Lỗi ngoài ý muốn", "Thông báo");
                 return false;
           }
       }

    
   }

    
   
}
