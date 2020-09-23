/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOKhachHang;
import DTO.MyCombobox;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLKhachHang {

    public static void DoDuLieuVaoCBBLoaiKhachHang(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAOKhachHang.LayLoaiKhachHangCBB();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenloaikhachhang"),
                        rs.getInt("idloaikhachhang"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }

    }

    public static void SetCBBLoaiKhachHang(JComboBox cbb, int MaLoaiKhachHang) {
        try {
            ResultSet rs = DAO.DAOKhachHang.LayMaLoaiKhachHangCBB(MaLoaiKhachHang);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenloaikhachhang"),
                        rs.getInt("idloaikhachhang"));

                cbbModel.setSelectedItem(mb);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }

    public static void HienThiKhachHangTheoMa(JTable tbl, int MaLKH) {
        ResultSet rs = DAO.DAOKhachHang.LayKhachHangTheoMaLoai(MaLKH);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idkhachhang");
                obj[1] = rs.getString("tenkhachhang");
                obj[2] = rs.getInt("sodienthoai");
                obj[3] = rs.getString("email");
                 obj[4] = ChuyenDoi.GetNgay(rs.getDate("ngaysinh"));
                obj[5] = rs.getString("diachi");
                if (rs.getString("gioitinh").equals("1")) {
                    obj[6] = "Nam";
                } else {
                    obj[6] = "Nữ";
                }
                obj[7] = rs.getString("anhdaidien");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ", "Thông báo");
        }

    }

    public static void HienThiKhachHang(JTable tbl) {
        ResultSet rs = DAO.DAOKhachHang.LayKhachHang();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idkhachhang");
                obj[1] = rs.getString("tenkhachhang");
                obj[2] = rs.getInt("sodienthoai");
                obj[3] = rs.getString("email");
                obj[4] = ChuyenDoi.GetNgay(rs.getDate("ngaysinh"));
                obj[5] = rs.getString("diachi");
                if (rs.getString("gioitinh").equals("1")) {
                    obj[6] = "Nam";
                } else {
                    obj[6] = "Nữ";
                }
                obj[7] = rs.getString("mangxahoi");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng khách hàng", "Thông báo");
        }

    }

    public static DTO.DTOKhachHang GetMaKH(Integer MaKH) {
        try {
            ResultSet rs = DAO.DAOKhachHang.LayKhachHangTheoMa(MaKH);
            if (rs.next()) {
                DTOKhachHang kh = new DTOKhachHang();
                kh.setIdKhachHang(rs.getInt("idkhachhang"));
                kh.setIdLoaiKhachHang(rs.getInt("idloaikhachhang"));
                kh.setIdNguoiDung(rs.getInt("idnguoidung"));
                kh.setTenKhachHang(rs.getString("tenkhachhang"));
                kh.setSoDienThoai(rs.getInt("sodienthoai"));
                kh.setEmail(rs.getString("email"));
                kh.setMatKhau(rs.getString("matkhau"));
                kh.setNgaySinh(ChuyenDoi.GetNgay(rs.getDate("ngaysinh")));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setGioiTinh(rs.getString("gioitinh"));
                kh.setMangXaHoi(rs.getString("mangxahoi"));
                kh.setAnhDaiDien(rs.getString("anhdaidien"));
                kh.setMoTa(rs.getString("mota"));
                kh.setTag(rs.getString("tag"));

                return kh;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng khách hàng", "Thông báo");
        }
        return null;
    }
     public static void ThemKhachHang(DTOKhachHang kh) {
        DAO.DAOKhachHang.ThemKhachHang(kh);
    }
      public static boolean KiemTraThemKhachHang( String TenKhachHang) {
        if (TenKhachHang.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
       
        return true;
    }


}
