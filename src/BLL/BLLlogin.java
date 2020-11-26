
package BLL;

import DTO.DTONguoidung;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takemikazuchi
 */
public class BLLlogin {

    public static DTO.DTONguoidung nguoidung = new DTONguoidung();

    public static boolean Checklogin(String username, String password) {
            if (username.trim().length() < 5) {
            //Thông báo
            ThongBaoCanhBao.ThongBao("Tên đăng nhập chưa hợp lệ", "Thông báo đăng nhập");
            return false;
        }
        if (password.trim().length() < 5) {
            ThongBaoCanhBao.ThongBao("Mật khẩu chưa hợp lệ", "Thông báo đăng nhập");
            return false;
        }
        ResultSet rs = DAO.DAONguoiDung.DangNhap(username);
        try {
            if (!rs.next()) {
                ThongBaoCanhBao.ThongBao("Tên đăng nhập không đúng", "Thông báo");
                return false;
            } else {
                if (!rs.getString("matkhau").equals(password)) {
                    ThongBaoCanhBao.ThongBao("Mật khẩu không đúng", "Thông báo");
                    return false;
                } else {
                    nguoidung.setAnhDaiDien(rs.getString("anhdaidien"));
                    nguoidung.setIdNguoiDung(rs.getInt("idnguoidung"));
                    nguoidung.setTenDangNhap(username);
                    nguoidung.setTenNguoiDung(rs.getString("tennguoidung"));
                }
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi câu lệnh SQL", "Thông báo lỗi");
            return false;
        }

        return true; 
     
    }

}