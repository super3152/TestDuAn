/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTONhaCungCap;
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
public class BLLNhaCungCap {
    
    public static void HienThiChiTietNhaCungCap(JTable tbl, int MaNCC) {
        ResultSet rs = DAO.DAONhaCungCap.LayPhieuNhapTheoMaNCC(MaNCC);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[7];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idnhacungcap");
                obj[1] = tbModel.getRowCount() + 1;
                obj[2] = rs.getString("sophieunhap");
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("ngaynhap"));
                int MaPN = rs.getInt("idphieunhap");
                ResultSet srSL = DAO.DAOChiTietPhieuNhap.LayCTPNTheoMaPN(MaPN);
                int SoLuong = 0;
                if (srSL.next()) {
                    int SoLuongCT = srSL.getInt("soluong");
                    SoLuong = SoLuong + SoLuongCT;
                    obj[4] = SoLuong;
                }
                obj[5] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                obj[6] = ChuyenDoi.DinhDangTien(rs.getDouble("congno"));

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ", "Thông báo");
        }

    }
    public static DTONhaCungCap GetMaNCC(Integer MaNCC) {
        try {
            ResultSet rs = DAO.DAONhaCungCap.LayNCCTheoMa(MaNCC);
            if (rs.next()) {
                DTONhaCungCap ncc = new DTONhaCungCap();
                ncc.setIDNhaCungCap(rs.getInt("idnhacungcap"));
                ncc.setTenNhaCungCap(rs.getString("tennhacungcap"));
                ncc.setMaNhaCungCap(rs.getString("manhacungcap"));
                ncc.setMaLoaiNhaCungCap(rs.getInt("idloainhacungcap"));
                ncc.setSoDienThoai(rs.getString("sodienthoai"));
                ncc.setEmail(rs.getString("email"));
                ncc.setDiaChi(rs.getString("diachi"));
                ncc.setTinh(rs.getString("tinh"));
                ncc.setSoFax(rs.getString("sofax"));
                ncc.setMaSoThue(rs.getString("masothue"));
                ncc.setWebSite(rs.getString("website"));
                ncc.setMaNguoiDung(rs.getInt("idnguoidung"));
                ncc.setTrangThai(rs.getInt("trangthai"));
                ncc.setLanCuoiNhapHang(rs.getString("lancuoinhaphang"));
                ncc.setTongTienHang(rs.getDouble("tongtienhang"));
                ncc.setCongNo(rs.getDouble("congno"));

                return ncc;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng nhà cung cấp", "Thông báo");
        }
        return null;
    }
    public static void SuaNhapHangNCC(DTONhaCungCap ncc) {
        DAO.DAONhaCungCap.SuaNhapHangNCC(ncc);
    }
     public static void SuaCongNoNCC(DTONhaCungCap ncc) {
        DAO.DAONhaCungCap.SuaCongNoNCC(ncc);
    }
        public static void DoDuLieuVaoCBBLoaiNhaCungCap(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAONhaCungCap.LayLoaiNhaCungCapCBB();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenloainhacungcap"),
                        rs.getInt("idloainhacungcap"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }

    }
      public static void DoDuLieuVaoCBBNguoiDung(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAONhaCungCap.LayNguoiDungCBB();

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
     
      public static void DoDuLieuVaoCBBNhaCungCap(JComboBox cbb) {
        try {
            ResultSet rs = DAO.DAONhaCungCap.LayNhacCungCapCBB();

          
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tennhacungcap"),
                        rs.getInt("idnhacungcap"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu!", "Thông Báo !");
        }
    }
      
      public static void SetCBBNguoiDung(JComboBox cbb, int MaNguoiDung) {
        try {
            ResultSet rs = DAO.DAONhaCungCap.LayMaNguoiDungCBB(MaNguoiDung);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
           
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tennguoidung"),
                        rs.getInt("idnguoidung"));

                cbbModel.setSelectedItem(mb);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }
       public static void SetCBBLoaiNhaCungCap(JComboBox cbb, int MaLoaiNhaCungCap) {
        try {
            ResultSet rs = DAO.DAONhaCungCap.LayNhaCungCapTheoMaLoai(MaLoaiNhaCungCap);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
           
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenloainhacungcap"),
                        rs.getInt("idloainhacungcap"));
                cbbModel.setSelectedItem(mb);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }
       
         public static void SetCBBLoaiNhaCungCap2(JTable tbl, int MaLoaiNhaCungCap) {
        try {
            ResultSet rs = DAO.DAONhaCungCap.LayNhaCungCapTheoMaLoai(MaLoaiNhaCungCap);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) tbl.getModel();
           
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenloainhacungcap"),
                        rs.getInt("idloainhacungcap"));
                cbbModel.setSelectedItem(mb);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }
      
         
      
         public static void HienThiNhaCungCap(JTable tbl, String TuKhoa) {
             
        ResultSet rs = DAO.DAONhaCungCap.LayNhaCungCap(TuKhoa);
      
     
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getInt("idnhacungcap");
                obj[2] = rs.getString("tennhacungcap");
                 ResultSet loainhacungcap = DAO.DAONhaCungCap.LayNhaCungCapTheoMaLoai(rs.getInt("idloainhacungcap"));
                if (loainhacungcap.next()) {
                    obj[3] = loainhacungcap.getString("tenloainhacungcap");
                }
                obj[4] = rs.getString("manhacungcap");
                obj[5] = rs.getInt("sodienthoai");
              
               
                obj[6] = rs.getString("email");
                
                int a = rs.getInt("trangthai");
                String b = String.valueOf(a);
                if (b.equals("1")) {
                     obj[7] = "<html><body style='color:blue;'>Đang hoạt động</body></html>";
                }else{
                      obj[7] = "<html><body style='color:red;'>Ngừng hoạt động</body></html>";
                }
               
             

                tbModel.addRow(obj);
             
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng nhà cung cấp", "Thông báo");
        }
        

    }
         
   
         
         
         
         
         
            public static void HienThiNhaCungCapLoc(JTable tbl,String idloainhacungcap, String idnguoidung) {
        ResultSet rs = DAO.DAONhaCungCap.LayNhaCungCapLoc(idloainhacungcap, idnguoidung);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getInt("idnhacungcap");
                obj[2] = rs.getString("tennhacungcap");
                 ResultSet loainhacungcap = DAO.DAONhaCungCap.LayNhaCungCapTheoMaLoai(rs.getInt("idloainhacungcap"));
                if (loainhacungcap.next()) {
                    obj[3] = loainhacungcap.getString("tenloainhacungcap");
                }
                obj[4] = rs.getString("manhacungcap");
                obj[5] = rs.getInt("sodienthoai");
                obj[6] = rs.getString("email");
                int a = rs.getInt("trangthai");
                String b = String.valueOf(a);
                if (b.equals("1")) {
                     obj[7] = "<html><body style='color:blue;'>Đang hoạt động</body></html>";
                }else{
                      obj[7] = "<html><body style='color:red;'>Ngừng hoạt động</body></html>";
                }
               
             

                tbModel.addRow(obj);
             
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng nhà cung cấp", "Thông báo");
        }

    }
         
          public static void HienThiNhaCungCapTheoMa(JTable tbl, int MaNCC) {
         ResultSet rs = DAO.DAONhaCungCap.LayNhaCungCapTheoMaLoai(MaNCC);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[14];
         try {
            while (rs.next()) {
                obj[0] = rs.getInt("idnhacungcap");
                obj[1] = rs.getString("tennhacungcap");
                obj[2] = rs.getString("manhacungcap");
                obj[3] = rs.getInt("sodienthoai");
                obj[4] = rs.getString("email");
                obj[5] = rs.getString("diachi");
                obj[6] = rs.getString("tinh");
                obj[7] = rs.getInt("sofax");
                obj[8] = rs.getString("masothue");
                obj[9] = rs.getString("website");
                obj[10] = rs.getInt("trangthai");
                obj[11] = rs.getString("tag");
                obj[12] = rs.getString("mota");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng nhà cung cấp", "Thông báo");
        }

    }
  
         public static void ThemNhaCungCap(DTONhaCungCap ncc) {
        DAO.DAONhaCungCap.ThemNhaCungCap(ncc);
    }

    public static boolean KiemTraThemNhaCungCap(String TenNhaCungCap, String MaNhaCungCap, int IDLoaiNhaCungCap, String SoDienThoai, String Email, String DiaChi, String Tinh, String SoFax, String MaSoThue, String WebSite, int IDNguoiDung, int TrangThai, String Tag, String MoTa) {
      
       
        return true;
    }
    
     public static void SuaNhaCungCap(DTO.DTONhaCungCap ncc) {
        DAO.DAONhaCungCap.SuaNhaCungCap(ncc);
    }
      public static boolean KiemTraSuaNhaCungCap( int IDNhaCungCap ,String TenNhaCungCap, String MaNhaCungCap, int IDLoaiNhaCungCap, String SoDienThoai, String Email, String DiaChi, String Tinh, String SoFax, String MaSoThue, String WebSite, int IDNguoiDung, int TrangThai, String Tag, String MoTa)  {
      
       
        return true;
    }
     
        public static void TraNoNhaCungCap(DTONhaCungCap ncc) {
        DAO.DAONhaCungCap.TraNoNhaCungCap(ncc);
    }
     
}
