/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOKhachHang;
import DTO.DTOLoaiKhachHang;
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

    public static void HienThiChiTietKhachHang(JTable tbl, int MaKH) {
        ResultSet rs = DAO.DAOKhachHang.LaySoKhachHangTrongHD(MaKH);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[7];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idkhachhang");
                obj[1] = tbModel.getRowCount() + 1;
                obj[2] = rs.getString("sohoadon");
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("ngaytaohoadon"));
                int MaHD = rs.getInt("idhoadon");
                ResultSet srSL = DAO.DAOChiTietHoaDon.LayCTHDTheoMaHD(MaHD);
                int SoLuong = 0;
                if (srSL.next()) {
                    int SoLuongCT = srSL.getInt("soluong");
                    SoLuong = SoLuong + SoLuongCT;
                    obj[4] = SoLuong;
                }
                obj[5] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));
                obj[6] = ChuyenDoi.DinhDangTien(rs.getDouble("congno"));

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ", "Thông báo");
        }

    }

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

    public static void DoDuLieuVaoCBBKhachHang(JComboBox cbb) {
        try {
            ResultSet rs = DAO.DAOKhachHang.LayKhachHangCBB();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenkhachhang"),
                        rs.getInt("idkhachhang"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu!", "Thông Báo !");
        }
    }

    public static void SetCBBKhachHang(JComboBox cbb, int MaKH) {
        try {
            ResultSet rs = DAO.DAOKhachHang.LayKhachHangTheoMa(MaKH);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenkhachhang"),
                        rs.getInt("idkhachhang"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu nhà cung cấp", "Thông báo");
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

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ", "Thông báo");
        }

    }

    public static void HienThiKhachHang(JTable tbl, String TuKhoa) {
        ResultSet rs = DAO.DAOKhachHang.LayKhachHang(TuKhoa);
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
                kh.setSoDienThoai(rs.getString("sodienthoai"));
                kh.setEmail(rs.getString("email"));
                kh.setMatKhau(rs.getString("matkhau"));
                kh.setNgaySinh(ChuyenDoi.GetNgay(rs.getDate("ngaysinh")));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setGioiTinh(rs.getString("gioitinh"));
                kh.setMangXaHoi(rs.getString("mangxahoi"));
                kh.setTongTienHang(rs.getDouble("tongtienhang"));
                kh.setCongNo(rs.getDouble("congno"));
                kh.setMoTa(rs.getString("mota"));
                kh.setTag(rs.getString("tag"));

                return kh;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng khách hàng", "Thông báo");
        }
        return null;
    }

    public static DTO.DTOKhachHang GetTenKH(String TenKH) {
        try {
            ResultSet rs = DAO.DAOKhachHang.LayKhachHangTheoTen(TenKH);
            if (rs.next()) {
                DTOKhachHang kh = new DTOKhachHang();
                kh.setIdKhachHang(rs.getInt("idkhachhang"));
                kh.setIdLoaiKhachHang(rs.getInt("idloaikhachhang"));
                kh.setIdNguoiDung(rs.getInt("idnguoidung"));
                kh.setTenKhachHang(rs.getString("tenkhachhang"));
                kh.setSoDienThoai(rs.getString("sodienthoai"));
                kh.setEmail(rs.getString("email"));
                kh.setMatKhau(rs.getString("matkhau"));
                kh.setNgaySinh(ChuyenDoi.GetNgay(rs.getDate("ngaysinh")));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setGioiTinh(rs.getString("gioitinh"));
                kh.setMangXaHoi(rs.getString("mangxahoi"));
                kh.setMoTa(rs.getString("mota"));
                kh.setTag(rs.getString("tag"));

                return kh;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng khách hàng", "Thông báo");
        }
        return null;
    }

    public static DTO.DTOLoaiKhachHang GetMaLoaiKH(int MaLoaiKH) {
        try {
            ResultSet rs = DAO.DAOKhachHang.LayMaLoaiKhachHangCBB(MaLoaiKH);
            if (rs.next()) {
                DTOLoaiKhachHang lkh = new DTOLoaiKhachHang();
                lkh.setIdLoaiKhachHang(rs.getInt("idloaikhachhang"));
                lkh.setTenLoaiKhachHang(rs.getString("tenloaikhachhang"));
                lkh.setUuDai(rs.getString("uudai"));
                lkh.setMoTa(rs.getString("mota"));

                return lkh;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng loại khách hàng", "Thông báo");
        }
        return null;
    }

    public static void ThemKhachHang(DTOKhachHang kh) {
        DAO.DAOKhachHang.ThemKhachHang(kh);
    }

    public static boolean KiemTraThemKhachHang(String TenKhachHang, String SDT, String Email, String MatKhau, String NgaySinh, String DiaChi, String MangXaHoi, String Tag, String MoTa) {
        if (TenKhachHang.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        String retenNH = "^[a-z A-z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$";
        if (!TenKhachHang.matches(retenNH)) {
            ThongBaoCanhBao.ThongBao("Tên khách hàng phải đúng định dạng"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        ResultSet rstenkh = DAO.DAOKhachHang.LayTenKhachHang(TenKhachHang);
        try {
            if (rstenkh.next()) {
                ThongBaoCanhBao.ThongBao("Tên khách hàng đã tồn tại "
                        + "\nVui lòng nhập số điện thoại khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        String resdt = "0\\d{9}";
        if (SDT.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không được bỏ trống!", "Thông báo");
            return false;
        } else if (!SDT.matches(resdt)) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không đúng định dạng!", "Thông báo");
            return false;
        }
        ResultSet rssdtkh = DAO.DAOKhachHang.LaySDTKhachHang(SDT);
        try {
            if (rssdtkh.next()) {
                ThongBaoCanhBao.ThongBao("Số điện thoai khách hàng đã tồn tại "
                        + "\nVui lòng nhập số điện thoại khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        if (Email.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Email không được bỏ trông!", "Thông báo");
            return false;
        } else if (!Email.matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            ThongBaoCanhBao.ThongBao("Email không đúng định dạng!", "Thông báo");
            return false;
        }
        ResultSet rsemail = DAO.DAOKhachHang.LayEmailKhachHang(Email);
        try {
            if (rsemail.next()) {
                ThongBaoCanhBao.ThongBao("Email đã tồn tại "
                        + "\nVui lòng nhập email khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        String Pass = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
        if (MatKhau.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Mật khẩu không được bỏ trống!", "Thông báo");
            return false;
        } else if (!MatKhau.matches(Pass)) {
            ThongBaoCanhBao.ThongBao("Mật khẩu không đúng định dạng!"
                    + "Phải có số từ 0-9"
                    + "Phải có kí tự thường a-z"
                    + "Phải có kí tự hoa A-Z"
                    + "Phải có kí tự đặc biệt trong mảng \"@#$%\""
                    + "Mật khẩu phải có chiều dài từ 6 đến 20 kí tự", "Thông báo");
            return false;
        }
        if (NgaySinh.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Ngày sinh không được bỏ trống", "Thông báo");
            return false;
        }
        String MXH = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (MangXaHoi.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Mạng xã hội  không được bỏ trống!", "Thông báo");
            return false;
        } else if (!MangXaHoi.matches(MXH)) {
            ThongBaoCanhBao.ThongBao("Mạng xã hội không đúng định dạng!", "Thông báo");
            return false;
        }
        if (DiaChi.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Địa chỉ khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại địa chỉ! ", "Thông báo");
            return false;
        }
        if (Tag.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tag không được bỏ trống", "Thông báo");
            return false;
        }
        if (MoTa.trim().length() < 5 || MoTa.trim().length() > 255) {
            ThongBaoCanhBao.ThongBao("Mô tả không được nhỏ hơn 5 và lớn hơn 255 kí tự", "Thông báo");
            return false;
        }

        return true;
    }

    public static void SuaKhachHang(DTOKhachHang kh) {
        DAO.DAOKhachHang.SuaKhachHang(kh);
    }

    public static boolean KiemTraSuaKhachHang(String TenKhachHang, String SDT, String Email, String MatKhau, String NgaySinh, String DiaChi, String MangXaHoi, String Tag, String MoTa) {
        if (TenKhachHang.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        String retenNH = "^[a-z A-z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$";
        if (!TenKhachHang.matches(retenNH)) {
            ThongBaoCanhBao.ThongBao("Tên khách hàng phải đúng định dạng"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        ResultSet rstenkh = DAO.DAOKhachHang.LayTenKhachHang(TenKhachHang);
        try {
            if (rstenkh.next()) {
                ThongBaoCanhBao.ThongBao("Tên khách hàng đã tồn tại "
                        + "\nVui lòng nhập số điện thoại khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        String resdt = "0\\d{9}";
        if (SDT.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không được bỏ trống!", "Thông báo");
            return false;
        } else if (!SDT.matches(resdt)) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không đúng định dạng!", "Thông báo");
            return false;
        }
        ResultSet rssdtkh = DAO.DAOKhachHang.LaySDTKhachHang(SDT);
        try {
            if (rssdtkh.next()) {
                ThongBaoCanhBao.ThongBao("Số điện thoai khách hàng đã tồn tại "
                        + "\nVui lòng nhập số điện thoại khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        if (Email.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Email không được bỏ trông!", "Thông báo");
            return false;
        } else if (!Email.matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            ThongBaoCanhBao.ThongBao("Email không đúng định dạng!", "Thông báo");
            return false;
        }
        ResultSet rsemail = DAO.DAOKhachHang.LayEmailKhachHang(Email);
        try {
            if (rsemail.next()) {
                ThongBaoCanhBao.ThongBao("Email đã tồn tại "
                        + "\nVui lòng nhập email khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        String Pass = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
        if (MatKhau.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Mật khẩu không được bỏ trống!", "Thông báo");
            return false;
        } else if (!MatKhau.matches(Pass)) {
            ThongBaoCanhBao.ThongBao("Mật khẩu không đúng định dạng!"
                    + "Phải có số từ 0-9"
                    + "Phải có kí tự thường a-z"
                    + "Phải có kí tự hoa A-Z"
                    + "Phải có kí tự đặc biệt trong mảng \"@#$%\""
                    + "Mật khẩu phải có chiều dài từ 6 đến 20 kí tự", "Thông báo");
            return false;
        }
        if (NgaySinh.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Ngày sinh không được bỏ trống", "Thông báo");
            return false;
        }
        String MXH = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (MangXaHoi.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Mạng xã hội  không được bỏ trống!", "Thông báo");
            return false;
        } else if (!MangXaHoi.matches(MXH)) {
            ThongBaoCanhBao.ThongBao("Mạng xã hội không đúng định dạng!", "Thông báo");
            return false;
        }
        if (DiaChi.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Địa chỉ khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại địa chỉ! ", "Thông báo");
            return false;
        }
        if (Tag.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tag không được bỏ trống", "Thông báo");
            return false;
        }
        if (MoTa.trim().length() < 5 || MoTa.trim().length() > 255) {
            ThongBaoCanhBao.ThongBao("Mô tả không được nhỏ hơn 5 và lớn hơn 255 kí tự", "Thông báo");
            return false;
        }

        return true;
    }

    public static void SuaHoaDonKhachHang(DTOKhachHang kh) {
        DAO.DAOKhachHang.SuaHoaDonKhachHang(kh);
    }

    public static void SuaNoTraHangKhachHang(DTOKhachHang kh) {
        DAO.DAOKhachHang.SuaNoTraHangKhachHang(kh);
    }
     public static void SuaLoaiKhachHang(DTOKhachHang kh) {
        DAO.DAOKhachHang.SuaLoaiKhachHang(kh);
    }
}
