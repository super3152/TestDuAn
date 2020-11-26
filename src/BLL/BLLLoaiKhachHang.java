/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOLoaiKhachHang;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLLoaiKhachHang {

    public static void HienThiLoaiKhachHang(JTable tbl) {
        ResultSet rs = DAO.DAOLoaiKhachHang.LayLoaiKhachHang();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idloaikhachhang");
                obj[1] = rs.getString("tenloaikhachhang");
                obj[2] = rs.getString("uudai");
                obj[3] = rs.getString("mota");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ loại khách hàng", "Thông báo");
        }

    }
     public static boolean KiemTraThemLoaiKhachHang(String TenLoaiKhachHang, String UuDai, String MoTa) {
        if (TenLoaiKhachHang.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên loại khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại tên! ", "Thông báo");
            return false;
        }
        String retenNH = "^[a-z A-z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$";
        if (!TenLoaiKhachHang.matches(retenNH)) {
            ThongBaoCanhBao.ThongBao("Tên loại khách hàng phải đúng định dạng"
                    + "\nVui lòng nhập lại tên! ", "Thông báo");
            return false;
        }
        ResultSet rstl = DAO.DAOLoaiKhachHang.LayLoaiKhachHangTheoTen(TenLoaiKhachHang);
        try {
            if (rstl.next()) {
                ThongBaoCanhBao.ThongBao("Tên loại khách hàng đã tồn tại ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        if (UuDai.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Ưu đãi không được bỏ trống!"
                    + "\nVui lòng nhập lại ưu đãi! ", "Thông báo");
            return false;
        }
         if (MoTa.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Mô tả không được bỏ trống!"
                    + "\nVui lòng nhập lại mô tả! ", "Thông báo");
            return false;
        }
        return true;
    }
     public static boolean KiemTraSuaLoaiKhachHang(String TenLoaiKhachHang, String UuDai, String MoTa) {
        if (TenLoaiKhachHang.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên loại khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại tên! ", "Thông báo");
            return false;
        }
        String retenNH = "^[a-z A-z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$";
        if (!TenLoaiKhachHang.matches(retenNH)) {
            ThongBaoCanhBao.ThongBao("Tên loại khách hàng phải đúng định dạng"
                    + "\nVui lòng nhập lại tên! ", "Thông báo");
            return false;
        }
        ResultSet rstl = DAO.DAOLoaiKhachHang.LayLoaiKhachHangTheoTen(TenLoaiKhachHang);
        try {
            if (rstl.next()) {
                ThongBaoCanhBao.ThongBao("Tên loại khách hàng đã tồn tại ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        if (UuDai.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Ưu đãi không được bỏ trống!"
                    + "\nVui lòng nhập lại ưu đãi! ", "Thông báo");
            return false;
        }
         if (MoTa.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Mô tả không được bỏ trống!"
                    + "\nVui lòng nhập lại mô tả! ", "Thông báo");
            return false;
        }
        return true;
    }
     public static void ThemLoaiKhachHang(DTOLoaiKhachHang lkh) {
        DAO.DAOLoaiKhachHang.ThemLoaiKhachHang(lkh);
    }
      public static void SuaLoaiKhachHang(DTOLoaiKhachHang lkh) {
        DAO.DAOLoaiKhachHang.SuaLoaiKhachHang(lkh);
    }
}
