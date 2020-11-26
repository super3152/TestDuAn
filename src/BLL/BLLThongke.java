/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.ThongBaoCanhBao;
import GUI.pnlsanpham;
import GUI.pnlthongke;
import GUI.pnltongquan;
import java.awt.Component;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author KMB1604
 */
public class BLLThongke {
     public static void HienThiThongKeSanPham(JTable tbl, String tukhoa) {
        ResultSet rs = DAO.DAOThongKe.LayThongKeSanPham(tukhoa);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getInt(3);
                obj[3] = rs.getDouble(4);
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thống kê sản phẩm", "Thông báo");
        }

    }
     
     public static class mytable implements TableCellRenderer{
       public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
           return (Component) value;
            
        }
    }
     
     
      public static void HienThiThongKeSanPhamBanChay2(JTable tbl) {
         pnltongquan.tblSanphambanchay.getColumn("Ảnh").setCellRenderer(new BLLThongke.mytable());  
        ResultSet rs = DAO.DAOThongKe.LayThongKeSanPhamBanChay2();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getInt(3);
                JLabel lb = new JLabel();
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rs.getBytes(4)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                System.out.println(imageIcon);   
                lb.setIcon(imageIcon);
            obj[1] = lb;
               
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thống kê sản phẩm bán chạy", "Thông báo");
        }

    }
     
     
     
      public static void HienThiThongKeHoaDon(JTable tbl) {
        ResultSet rs = DAO.DAOThongKe.LayThongKeHoaDon();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getDate(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getDouble(5);
                obj[5] = rs.getDouble(6);
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thống kê sản phẩm", "Thông báo");
        }

    }
     
      public static void HienThiThongKeSanPhamBanChay(JTable tbl) {
        ResultSet rs = DAO.DAOThongKe.LayThongKeSanPhamBanChay();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[5];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getInt(4);
                obj[4] = rs.getDouble(5);
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thống kê sản phẩm", "Thông báo");
        }

    }
      
      
       public static void HienThiThongKeSanPhamTheoNgay(JTable tbl, String ngaybatdau, String ngayketthuc) {
        ResultSet rs = DAO.DAOThongKe.TimKiemSanPhamTheoNgay(ngaybatdau, ngayketthuc);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[5];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getInt(4);
                obj[4] = rs.getDouble(5);
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thống kê sản phẩm", "Thông báo");
        }

    }
       
       
          public static void HienThiThongKePhieuNhap(JTable tbl) {
        ResultSet rs = DAO.DAOThongKe.LayThongPhieuNhap();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[5];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getDate(3);
                obj[3] = rs.getDouble(4);
                obj[4] = rs.getDouble(5);
              
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thống kê sản phẩm", "Thông báo");
        }

    }
          
          public static void HienThiSanPham(JTable tbl, String Ngay) {
        
        
        ResultSet rs = DAO.DAOThongKe.LayThongKe7Ngay(Ngay);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[1];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt(3);
                tbModel.addRow(obj);   
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu 7 ngày", "Thông báo");
            System.out.println(ex);
        }
    }
    
}
