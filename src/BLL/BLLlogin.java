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
import DTO.DTONguoidung;

/**
 *
 * @author Takemikazuchi
 */
public class BLLlogin {
     public static Connection con;
   public static PreparedStatement pst;
   public static ResultSet rs;
   public static DTONguoidung nd = new DTONguoidung();

   

     public static boolean KiemTra(String username, String password) {
        if (username.trim().length() < 5) {
            //Thông báo
            ThongBaoLoi.ThongBao("Tên đăng nhập chưa hợp lệ", "Thông báo đăng nhập");
            return false;
        }
        if (password.trim().length() < 5) {
            ThongBaoLoi.ThongBao("Mật khẩu chưa hợp lệ", "Thông báo đăng nhập");
            return false;
        }
        //Gọi hàm kiểm tra đăng nhập với SQL từ tầng DAO
        ResultSet rs = DAO.DAOnguoidung.DangNhap(username);
        try {
            if (!rs.next()) {
                ThongBaoLoi.ThongBao("Tên đăng nhập không đúng", "Thông báo");
                return false;
            } else {
                if (!rs.getString("MatKhau").equals(password)) {
                    ThongBaoLoi.ThongBao("Mật khẩu không đúng", "Thông báo");
                    return false;
                } else {
                    nd.setTendangnhap(username);
                    System.out.println();

                }
            }
        } catch (SQLException ex) {
            ThongBaoLoi.ThongBao("Lỗi câu lệnh SQL", "Thông báo lỗi");
            return false;
        }

        return true; //Nếu thông tin hợp và khớp username + password
    }
   
}
