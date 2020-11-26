/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOKhachHang;
import DTO.DTONguoidung;
import DTO.MyCombobox;
import GUI.ThongBaoCanhBao;
import static GUI.pnlnhanvien.readLogo;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Administrator
 */
public class BLLNguoiDung {

    public static void DoDuLieuVaoCBBLuong(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAONguoiDung.LayMucLuongCBB();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(ChuyenDoi.DinhDangTien(rs.getDouble("mucluong")),
                        rs.getInt("idluong"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }

    }

    public static void SetCBBLuong(JComboBox cbb, int MaLuong) {
        try {
            ResultSet rs = DAO.DAONguoiDung.LayMaLuongCBB(MaLuong);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(ChuyenDoi.DinhDangTien(rs.getDouble("mucluong")),
                        rs.getInt("idluong"));

                cbbModel.setSelectedItem(mb);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }
 public static void DoDuLieuVaoCBBNguoiDung(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAONguoiDung.LayNhanVienCBB();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tennguoidung"),
                        rs.getInt("idnguoidung"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }

    }

    public static void SetCBBNguoiDung(JComboBox cbb, int MaND) {
        try {
            ResultSet rs = DAO.DAONguoiDung.LayNguoiDungTheoMa(MaND);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tennguoidung"),
                        rs.getInt("idnguoidung"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu nhà cung cấp", "Thông báo");
        }
    }

    public static void HienThiNguoiDungTheoChucVu(JTable tbl, int ChucVu) {
        ResultSet rs = DAO.DAONguoiDung.LayNguoiDungTheoChucVu(ChucVu);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[11];
        try {
             while (rs.next()) {
                obj[0] = rs.getInt("idnguoidung");
                obj[1] = rs.getString("tennguoidung");
                obj[2] = rs.getInt("sodienthoai");
                obj[3] = rs.getString("email");
                if (rs.getString("gioitinh").equals("1")) {
                    obj[4] = "Nam";
                } else {
                    obj[4] = "Nữ";
                }
                obj[5] = ChuyenDoi.GetNgay(rs.getDate("ngaysinh"));
               obj[6] = ChuyenDoi.GetNgay(rs.getDate("ngayvaolam"));
                obj[7] = rs.getString("anhdaidien");
                if (rs.getString("quyen").equals("1")) {
                    obj[8] = "Quản Trị";
                } else {
                    obj[8] = "Nhân Viên";
                }
                if (rs.getString("trangthai").equals("1")) {
                    obj[9] = "Đang làm việc";
                } else {
                    obj[9] = "Đã nghỉ làm";
                }
                int MaLuong = rs.getInt("idluong");
                ResultSet rsLuong = DAO.DAONguoiDung.LayMaLuong(MaLuong);
                if (rsLuong.next()) {
                    obj[10] = ChuyenDoi.DinhDangTien(rsLuong.getDouble("mucluong"));
                }


                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng người dùng", "Thông báo");
        }

    }

    public static void HienThiNguoiDung(JTable tbl, String TuKhoa) {
        ResultSet rs = DAO.DAONguoiDung.LayNguoiDung(TuKhoa);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[11];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idnguoidung");
                obj[1] = rs.getString("tennguoidung");
                obj[2] = rs.getInt("sodienthoai");
                obj[3] = rs.getString("email");
                if (rs.getString("gioitinh").equals("1")) {
                    obj[4] = "Nam";
                } else {
                    obj[4] = "Nữ";
                }
                obj[5] = ChuyenDoi.GetNgay(rs.getDate("ngaysinh"));
               obj[6] = ChuyenDoi.GetNgay(rs.getDate("ngayvaolam"));
                obj[7] = rs.getString("anhdaidien");
                if (rs.getString("quyen").equals("1")) {
                    obj[8] = "Quản Trị";
                } else {
                    obj[8] = "Nhân Viên";
                }
                if (rs.getString("trangthai").equals("1")) {
                    obj[9] = "Đang làm việc";
                } else {
                    obj[9] = "Đã nghỉ làm";
                }
                int MaLuong = rs.getInt("idluong");
                ResultSet rsLuong = DAO.DAONguoiDung.LayMaLuong(MaLuong);
                if (rsLuong.next()) {
                    obj[10] = ChuyenDoi.DinhDangTien(rsLuong.getDouble("mucluong"));
                }

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng người dùng", "Thông báo");
        }

    }

    public static DTO.DTONguoidung GetMaND(Integer MaND) {
        try {
            ResultSet rs = DAO.DAONguoiDung.LayNguoiDungTheoMa(MaND);
            if (rs.next()) {
                DTONguoidung nd = new DTONguoidung();
                nd.setIdNguoiDung(rs.getInt("idnguoidung"));
                nd.setIdLuong(rs.getInt("idluong"));
                nd.setTenNguoiDung(rs.getString("tennguoidung"));
                nd.setSoDienThoai(rs.getString("sodienthoai"));
                nd.setEmail(rs.getString("email"));
                nd.setGioiTinh(rs.getString("gioitinh"));
                nd.setNgaySinh(ChuyenDoi.GetNgay(rs.getDate("ngaysinh")));
                nd.setNgayVaoLam(ChuyenDoi.GetNgay(rs.getDate("ngayvaolam")));
                nd.setDiaChi(rs.getString("diachi"));
                nd.setCMND(rs.getString("cmnd"));
                nd.setTenDangNhap(rs.getString("tendangnhap"));
                nd.setMatKhau(rs.getString("matkhau"));
                nd.setAnhDaiDien(rs.getString("anhdaidien"));
                nd.setQuyen(rs.getInt("quyen"));
                nd.setTrangThai(rs.getInt("trangthai"));
                nd.setMoTa(rs.getString("mota"));
                return nd;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng người dùng", "Thông báo");
        }
        return null;
    }

    public static boolean KiemTraThemNguoiDung(String TenNguoiDung, String SoDienThoai, String Email, String NgaySinh, String NgayVaoLam, String DiaChi, String CMND, String TenDangNhap, String MatKhau, String MoTa) {
        if (TenNguoiDung.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên nhân viên không được bỏ trống!"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        String retenNH = "^[a-z A-z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$";
        if (!TenNguoiDung.matches(retenNH)) {
            ThongBaoCanhBao.ThongBao("Tên nhân viên phải đúng định dạng"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        ResultSet rstennv = DAO.DAONguoiDung.LayTenNguoiDung(TenNguoiDung);
        try {
            if (rstennv.next()) {
                ThongBaoCanhBao.ThongBao("Tên nhân viên đã tồn tại "
                        + "\nVui lòng nhập tên khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        String resdt = "0\\d{9}";
        if (SoDienThoai.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không được bỏ trống!", "Thông báo");
            return false;
        } else if (!SoDienThoai.matches(resdt)) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không đúng định dạng!", "Thông báo");
            return false;
        }
        ResultSet rssdtkh = DAO.DAONguoiDung.LaySDTNguoiDung(SoDienThoai);
        try {
            if (rssdtkh.next()) {
                ThongBaoCanhBao.ThongBao("Số điện thoai nhân viên đã tồn tại "
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
        ResultSet rsemail = DAO.DAONguoiDung.LayEmailNguoiDung(Email);
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

        String ChungMinh = "[0-9]{9}";
        if (!CMND.matches(ChungMinh)) {
            ThongBaoCanhBao.ThongBao("Bạn nhập chưa đúng định dạng số CMND", "Thông báo lỗi");
            return false;
        }
           ResultSet rscmnd = DAO.DAONguoiDung.LayCMNDNguoiDung(CMND);
        try {
            if (rscmnd.next()) {
                ThongBaoCanhBao.ThongBao("CMND đã tồn tại "
                        + "\nVui lòng nhập CMND khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
        }
        if (DiaChi.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Địa chỉ khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại địa chỉ! ", "Thông báo");
            return false;
        }
        if (MoTa.trim().length() < 5 || MoTa.trim().length() > 255) {
            ThongBaoCanhBao.ThongBao("Mô tả không được nhỏ hơn 5 và lớn hơn 255 kí tự", "Thông báo");
            return false;
        }

        return true;
    }

    public static void ThemNguoiDung(DTONguoidung nd) {
        DAO.DAONguoiDung.ThemNguoiDung(nd);
    }
      public static boolean KiemTraSuaNguoiDung(String TenNguoiDung, String SoDienThoai, String Email, String NgaySinh, String NgayVaoLam, String DiaChi, String CMND, String TenDangNhap, String MatKhau, String MoTa) {
        if (TenNguoiDung.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên nhân viên không được bỏ trống!"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        String retenNH = "^[a-z A-z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$";
        if (!TenNguoiDung.matches(retenNH)) {
            ThongBaoCanhBao.ThongBao("Tên nhân viên phải đúng định dạng"
                    + "\nVui lòng nhập lại họ tên! ", "Thông báo");
            return false;
        }
        ResultSet rstennv = DAO.DAONguoiDung.LayTenNguoiDung(TenNguoiDung);
        try {
            if (rstennv.next()) {
                ThongBaoCanhBao.ThongBao("Tên nhân viên đã tồn tại "
                        + "\nVui lòng nhập tên khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
            return false;
        }
        String resdt = "0\\d{9}";
        if (SoDienThoai.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không được bỏ trống!", "Thông báo");
            return false;
        } else if (!SoDienThoai.matches(resdt)) {
            ThongBaoCanhBao.ThongBao("Số điện thoại không đúng định dạng!", "Thông báo");
            return false;
        }
        ResultSet rssdtkh = DAO.DAONguoiDung.LaySDTNguoiDung(SoDienThoai);
        try {
            if (rssdtkh.next()) {
                ThongBaoCanhBao.ThongBao("Số điện thoai nhân viên đã tồn tại "
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
        ResultSet rsemail = DAO.DAONguoiDung.LayEmailNguoiDung(Email);
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

        String ChungMinh = "[0-9]{9}";
        if (!CMND.matches(ChungMinh)) {
            ThongBaoCanhBao.ThongBao("Bạn nhập chưa đúng định dạng số CMND", "Thông báo lỗi");
            return false;
        }
          ResultSet rscmnd = DAO.DAONguoiDung.LayCMNDNguoiDung(CMND);
        try {
            if (rscmnd.next()) {
                ThongBaoCanhBao.ThongBao("CMND đã tồn tại "
                        + "\nVui lòng nhập CMND khác! ", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");
        }
        if (DiaChi.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Địa chỉ khách hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại địa chỉ! ", "Thông báo");
            return false;
        }
        if (MoTa.trim().length() < 5 || MoTa.trim().length() > 255) {
            ThongBaoCanhBao.ThongBao("Mô tả không được nhỏ hơn 5 và lớn hơn 255 kí tự", "Thông báo");
            return false;
        }

        return true;
    }
        public static void SuaNguoiDung(DTONguoidung nd) {
        DAO.DAONguoiDung.SuaNhanVien(nd);
    }
          public static boolean KiemTraPhatLuong(int MaNV, String NgayPhat, String SoNgayDiLam, String SoNgayNghi, String TienThuong, String TienPhat, String GhiChu, int MaLuong, String Tong) {
        if (TienThuong.length() == 1) {
            ThongBaoCanhBao.ThongBao("Vui lòng phập tiền thưởng!", "Thông báo");
            return false;
        }
        if (TienPhat.length() == 1) {
            ThongBaoCanhBao.ThongBao("Vui lòng phập tiền phạt!", "Thông báo");
            return false;
        }
        if (GhiChu.length() < 1 || GhiChu.length() > 255) {
            ThongBaoCanhBao.ThongBao("Ghi chú không được bỏ trống và lớn hơn 255 kí tự!", "Thông báo");
            return false;
        }

        return true;
    }
          public static void PhatLuong(DTO.DTOPhatLuong pl) {
        DAO.DAOPhatLuong.PhatLuong(pl);
    }
}
