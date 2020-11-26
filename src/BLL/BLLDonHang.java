/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTODonHang;
import DTO.DTOHinhThucGiaoHang;
import DTO.MyCombobox;
import GUI.pnlgiaohang;
import GUI.ThongBaoCanhBao;
import static GUI.jdlDonHang.tblChiTietHoaDonSanPham;
import java.awt.Component;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author KMB1604
 */
public class BLLDonHang {
     public static void HienThiDonHang(JTable tbl, String TuKhoa) {
        ResultSet rs = DAO.DAODonHang.LayDonHang(TuKhoa);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                 obj[0] = tbModel.getRowCount() + 1;
                 obj[1] = rs.getString("idhoadon");
                 
                obj[2] = rs.getString("sohoadon");
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("ngaytaohoadon"));           
                String Time = new SimpleDateFormat("HH:mm:ss").format(rs.getTimestamp("ngaytaohoadon"));       
                obj[4] = Time;
                
                
                
                int idkhachhang = rs.getInt("idkhachhang");
                
                if (idkhachhang == 0) {
                     int idnonkhachhang = rs.getInt("idnonkhachhang");
                      ResultSet rsLSP = DAO.DAODonHang.LayKhachHangNotLogin(idnonkhachhang);
                if (rsLSP.next()) {
                    obj[5] = "[Khách] - "+ rsLSP.getString("hovaten");
                }
                    
                }else{
                    ResultSet rsLSP = DAO.DAODonHang.LayKhachHang(idkhachhang);
                if (rsLSP.next()) {
                    obj[5] = rsLSP.getString("tenkhachhang");
                }
                }
                
                
              
                
                
                
                
               if (rs.getInt("trangthaihoadon") == 1) {
                     obj[6] = "<html><body style='color:red;'>Chờ duyệt</body></html>";
                } else if(rs.getInt("trangthaihoadon") == 2){
                     obj[6] = "<html><body style='color:blue;'>Đóng gói</body></html>";
                } else if(rs.getInt("trangthaihoadon") == 3){
                     obj[6] = "<html><body style='color:blue;'>Xuất kho</body></html>";
                } else if(rs.getInt("trangthaihoadon") == 4){
                     obj[6] = "<html><body style='color:blue;'>Đang giao hàng</body></html>";
                } else if(rs.getInt("trangthaihoadon") == 5){
                     obj[6] = "<html><body style='color:blue;'>Hoàn thành</body></html>";
                } else {
                     obj[6] = "<html><body style='color:red;'>[Đã hủy]</body></html>";
                } 
                     
               
                
                
                 if (rs.getInt("tinhtrang") == 0) {
                     obj[7] = "<html><body style='color:red;'>Chưa thanh toán</body></html>";
                } else {
                    obj[7] = "<html><body style='color:blue;'>Đã thanh toán</body></html>";
                }
                obj[8] = rs.getDouble("tongtien");
                
                if (rs.getInt("view") == 0) {
                    obj[9] = "<html><body style='color:red;'>Đơn Mới</body></html>";
                }else{
                    obj[9] = "<html><body style='color:blue;'>Đã Xem</body></html>";
                }
                
                
                
                
                
                
                

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng đơn hàng", "Thông báo");
        }

    }
     
     
       public static void HienThiChiTietDonHang(JTable tbl, String TuKhoa) {
        ResultSet rs = DAO.DAODonHang.LayChiTietDonHang(TuKhoa);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[0];
        try {
            while (rs.next()) {
                 obj[0] = tbModel.getRowCount() + 1;
                 obj[1] = rs.getInt("idchitiethoadon");
                 
                  obj[2] = rs.getInt("anhsanpham");//sp
                   obj[3] = rs.getInt("masanpham");//sp
                    obj[4] = rs.getInt("idsanpham");//sp
                    
                     obj[5] = rs.getInt("idsize");//sp
                      obj[6] = rs.getInt("idmau");//sp
                      
                       obj[7] = rs.getInt("soluong");
                       
                        obj[8] = rs.getInt("dongia");//sp
                        
                         obj[9] = rs.getInt("uudai");
                          obj[10] = rs.getInt("thanhtien");
                    
                
              
                
                
                
               
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng chi tiết đơn hàng", "Thông báo");
        }

    }
     
     
     
     
      public static DTO.DTODonHang GetMaDH(Integer MaDH) {
        try {
            ResultSet rs = DAO.DAODonHang.LayDonHangTheoMa(MaDH);
            System.out.println(MaDH);
              System.out.println(rs);
            if (rs.next()) {
                DTODonHang dh = new DTODonHang();
                dh.setTrangthaihoadon(rs.getInt("trangthaihoadon"));
                
                
                
                
                
                dh.setTinhtrang(rs.getInt("tinhtrang"));
                
                dh.setDiachi(rs.getString("diachigiaohang"));
                dh.setSodienthoai(rs.getInt("sodienthoai"));
                dh.setIdhoadon(rs.getInt("idhoadon"));
                dh.setSoHoaDon(rs.getString("sohoadon"));
                dh.setMaKhachHang(rs.getInt("idkhachhang"));
                
                String Time = new SimpleDateFormat("dd/MM/yyyy").format(rs.getTimestamp("ngaytaohoadon"));    
                dh.setNgayTaoHoaDon(Time);
                
                String Time2 = new SimpleDateFormat("HH:mm:ss").format(rs.getTimestamp("ngaytaohoadon"));    
                dh.setTimeTaoHoaDon(Time2);
                
                
                dh.setHinhthucthanhtoan(rs.getInt("hinhthucthanhtoan"));
                dh.setTongTien(rs.getDouble("tongtien"));
              dh.setHinhthucvanchuyen(rs.getInt("idhinhthuc"));
              dh.setTiengiaohang(rs.getDouble("tiengiaohang"));
                System.out.println(dh);

                return dh;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng đơn hàng", "Thông báo");
        }
        return null;
    }
      
      
      public static void SuaDonHang(DTODonHang dh) {
        DAO.DAODonHang.SuaDonHang(dh);
          System.out.println(dh);
    }
       public static void SuaDonHangView(DTODonHang dh) {
        DAO.DAODonHang.SuaDonHangView(dh);
         System.out.println(dh);
    }
      
       public static boolean KiemTraSuaDonHang(int iddonhang,int trangthaidonhang) {
       return true;
       }
       
       public static boolean KiemTraSuaDonHangView(int iddonhang,String view) {
       return true;
       }
       
       
       
        public static void SuaTienGiaoHang(DTODonHang gh) {
        DAO.DAODonHang.SuaTienGiaoHang(gh);
            System.out.println(gh);
        
    }
      
       public static boolean KiemTraSuaTienGiaoHang(int idhoadon,String tiengiaohang, int hinhthucgiaohang) {
            if (tiengiaohang.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tiền giao hàng không được bỏ trống!"
                    + "\nVui lòng nhập lại! ", "Thông báo");
            return false;
        }
           
       return true;
       }
       
       
        public static class mytable implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;

        }
    }
       
       
        public static void HienThiChiTietDonHangSanPham(JTable tbl, int iddonhang) {
            tblChiTietHoaDonSanPham.getColumn("Ảnh").setCellRenderer(new mytable());
           
      
        ResultSet rs = DAO.DAODonHang.laychitietdonhang(iddonhang);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idchitiethoadon");    
                
                JLabel lb = new JLabel();
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rs.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[1] = lb;
                obj[2] = rs.getString("masanpham");
                obj[3] = rs.getString("tensanpham");
                obj[4] = rs.getInt("idsizesanpham");
                obj[5] = rs.getInt("idmausanpham");
                obj[6] = rs.getInt("soluong");
                obj[7] = rs.getDouble("giabanle");
                obj[8] = rs.getDouble("uudai");
                obj[9] = rs.getDouble("thanhtien");               
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng Sản Phẩm", "Thông báo");
        }
    }
       
       
       
          public static void ThemHinhThuc(DTOHinhThucGiaoHang giaohang) {
        DAO.DAODonHang.ThemHinhThuc(giaohang);
    }

    public static boolean KiemTraThemHinhThuc(String tenhinhthuc, String Mota) {
        if (tenhinhthuc.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên hình thức không được bỏ trống!"
                    + "\nVui lòng nhập lại hình thức! ", "Thông báo");
            return false;
        }
        return true;
    }
        
         public static void HienThiHinhThucGH(JTable tbl) {

        ResultSet rs = DAO.DAODonHang.HienThiHinhThuc();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[3];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idhinhthuc");
                obj[1] = rs.getString("tenhinhthuc");
                obj[2] = rs.getString("mota");
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hình thức", "Thông báo");
        }
    }
         
         
         
         
         public static void DoDuLieucbbHinhThuc(JComboBox cbbHinhThuc) {
        ResultSet rs = DAO.DAODonHang.LayHinhThuc("");
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbHinhThuc.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdHinhThuc  = rs.getString("idhinhthuc");
                Object TenHinhThuc = rs.getString("tenhinhthuc");
                MyCombobox mb = new MyCombobox(TenHinhThuc, IdHinhThuc);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb hình thức", "Thông Báo");
            
        }
    }
        
}
