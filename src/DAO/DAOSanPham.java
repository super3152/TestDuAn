/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOSanPham;
import static GUI.pnlsanpham.tblThemThuocTinh;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrator
 */
public class DAOSanPham {
     public static ResultSet LaySizeTheoTenSanPham( String TenSP) {
        String query = "SELECT DISTINCT sizesanpham.`tensize` AS tensize, sanpham.`idsizesanpham` AS idsize FROM"
                + " `sizesanpham` sizesanpham INNER JOIN `sanpham` sanpham ON sizesanpham.`idsize` = sanpham.`idsizesanpham` WHERE tensanpham = '"+TenSP+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayMauTheoTenSanPhamRi( String TenSP) {
        String query = "SELECT DISTINCT mausanpham.`tenmausanpham` AS tenmausanpham, sanpham.`idmausanpham` AS idmausanpham FROM `mausanpham` mausanpham "
                + "INNER JOIN `sanpham` sanpham ON mausanpham.`idmausanpham` = sanpham.`idmausanpham` WHERE tensanpham = '"+TenSP+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayMauTheoSizeTenSanPham( String TenSP, int SizeSP) {
        String query = "SELECT mausanpham.`tenmausanpham` AS tenmausanpham, sanpham.`idmausanpham` AS idmausanpham FROM "
                + "`mausanpham` mausanpham INNER JOIN `sanpham` sanpham ON mausanpham.`idmausanpham` = sanpham.`idmausanpham` WHERE tensanpham = '"+TenSP+"' and idsizesanpham = '"+SizeSP+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet GetByTenSP(String TenSanPham, int MaSize, int MaMau) {
        String cauTruyVan = "select * from sanpham where tensanpham = '" + TenSanPham + "' and idsizesanpham = '"+MaSize+"' and idmausanpham = '"+MaMau+"' ";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
      public static ResultSet GetByTenSize(String TenSize) {
        String cauTruyVan = "select * from sizesanpham where tensize = '"+TenSize+"'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
    public static ResultSet LayTenSanPham() {
        String query = "SELECT DISTINCT tensanpham FROM sanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LaySanPham() {
        String query = "SELECT * FROM sanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayLoaiSanPham(int MaLoaiSanPham) {
        String query = "SELECT * FROM loaisanpham where idloaisanpham = '"+MaLoaiSanPham+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayHangSanPham(int MaHangSanPham) {
        String query = "SELECT * FROM hangsanpham where idhangsanpham = '"+MaHangSanPham+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LaySizeSanPham(int MaSizeSanPham) {
        String query = "SELECT * FROM sizesanpham where idsize = '"+MaSizeSanPham+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayMauSanPham(int MaMauSanPham) {
        String query = "SELECT * FROM mausanpham where idmausanpham = '"+MaMauSanPham+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayKeSanPham(int MaKeSanPham) {
        String query = "SELECT * FROM kesanpham where idke = '"+MaKeSanPham+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LaySanPhamTheoMa(int MaSanPham) {
          String query = "SELECT * FROM sanpham where idsanpham = '"+MaSanPham+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LaySanPhamTheoId(String idsanPham) {
        String query = "SELECT * FROM `sanpham` WHERE `idsanpham`= '" + idsanPham + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
          public static ResultSet LaySanPhamTheoTenSPSize(String TenSP, int SizeSP) {
        String query = "SELECT * FROM `sanpham` WHERE `tensanpham`= '" + TenSP + "' and idsizesanpham = '"+SizeSP+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
           public static ResultSet LaySanPhamTheoTenSPMau(String TenSP, int MauSP) {
        String query = "SELECT * FROM `sanpham` WHERE `tensanpham`= '" + TenSP + "' and idmausanpham = '"+MauSP+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static int SuaSoLuong(DTOSanPham sp) {
        String query = "UPDATE `sanpham` SET `tonkho`= '"+sp.getTonKho()+"'"
                + " WHERE `idsanpham`='"+sp.getIDSanPham()+"' ";
         System.out.println(query);
       return DBConection.ExcuteTruyVan(query);
    }
      public static ResultSet LaySanPhamLoc(String IDHangSanPham, String IDLoaiSanPham, String IDSizeSanPham, String IDMauSanPham, String IDKe, String NgayTao) {
        String query = "SELECT "
                + "    * "
                + "FROM "
                + "    sanpham "
                + "WHERE "
                + "    idhangsanpham = '" + IDHangSanPham + "' "
                + "AND idloaisanpham = '" + IDLoaiSanPham + "' "
                + "AND idsizesanpham = '" + IDSizeSanPham + "' "
                + "AND idmausanpham = '" + IDMauSanPham + "' "
                + "AND idke = '" + IDKe + "' "
                + "AND ngaytao = '" + NgayTao + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
        public static int XoaSP(int IDSanPham) {
        String query = "DELETE FROM `sanpham` WHERE `idsanpham` = '" + IDSanPham + "'";
        int kq = DBConection.ExcuteTruyVan(query);
        return kq;
    }
 public static int XoaSize(int IDSize) {
        String query = "DELETE FROM `sizesanpham` WHERE `idsize` = '" + IDSize + "'";
        int kq = DBConection.ExcuteTruyVan(query);
        return kq;
    }
 public static int XoaMau(int IDMau) {
        String query = "DELETE FROM `mausanpham` WHERE `idmausanpham` = '" + IDMau + "'";
        int kq = DBConection.ExcuteTruyVan(query);
        return kq;
    }
    
   
  public static PreparedStatement pst = null;
    public static void ThemSanPham(DTO.DTOSanPham sp) {
        
        try {  
           pst = DBConection.conn.prepareStatement ("INSERT INTO sanpham(tensanpham,ngaytao,masanpham,motasanpham,giabanle,giabanbuon,gianhap,khoiluong,donvitinh,tonkho,idloaisanpham,idhangsanpham,thuoctinhkhachhang,anhsanpham,idsizesanpham,idmausanpham,idke)"+"values(?,?,?,?,?,?,?,?,?,'0',?,?,?,?,?,?,?)");
           
              pst.setString(1, sp.getTenSanPham());
              pst.setString(2, sp.getNgayTao());
              pst.setString(3, sp.getMaSanPham());
              pst.setString(4, sp.getMoTaSanPham());
              pst.setDouble(5, sp.getGiaBanLe());
              pst.setDouble(6, sp.getGiaBanBuon());
              pst.setDouble(7, sp.getGiaNhap());
              pst.setInt(8, sp.getKhoiLuong());
              pst.setString(9, sp.getDonViTinh());
             
              pst.setInt(10, sp.getIDLoaiSanPham());
              pst.setInt(11, sp.getIDHangSanPham());
              pst.setString(12, sp.getThuocTinhKhachHang());
             InputStream img = new FileInputStream(new File(tblThemThuocTinh.getValueAt(0, 8).toString()));
              pst.setBlob(13, img);
              
              
              pst.setInt(14, sp.getIDSize());
              
              
              pst.setInt(15, sp.getIDMauSanPham());
              pst.setInt(16, sp.getIDKe());
               
           
            pst.executeUpdate();
            System.out.println(pst);
        } catch (SQLException ex) {
             System.out.println(pst);
            System.out.println("Lỗi lấy dữ liệu");
        } catch(FileNotFoundException e){
            System.out.println("Fail");
             System.out.println(pst);
        }
       
    return;
    }

    public static ResultSet LaySanPhamTimKiem(String timKiem) {
        String query = "SELECT "
                + "    * "
                + "FROM "
                + "    sanpham "
                + "WHERE "
                + "    tensanpham like '%" + timKiem + "%' "
                + "or masanpham like '%" + timKiem + "%' "
                + "or idsanpham like '%" + timKiem + "%' ";
        System.out.println(query);
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static void suaSP(DTO.DTOSanPham sp) {
         if(ImagePast == null){
        try {  
           pst = DBConection.conn.prepareStatement ("UPDATE sanpham SET tensanpham = ?,ngaytao = ?,masanpham = ?,motasanpham = ?,giabanle = ?,giabanbuon = ?,gianhap = ?,khoiluong = ?,donvitinh = ?,tonkho = ?,idloaisanpham = ?,idhangsanpham = ?,thuoctinhkhachhang = ?,idsizesanpham = ?,idmausanpham = ?,idke = ?"+ " WHERE idsanpham = ?");
           
              pst.setString(1, sp.getTenSanPham());
              pst.setString(2, sp.getNgayTao());
              pst.setString(3, sp.getMaSanPham());
              pst.setString(4, sp.getMoTaSanPham());
              pst.setDouble(5, sp.getGiaBanLe());
              pst.setDouble(6, sp.getGiaBanBuon());
              pst.setDouble(7, sp.getGiaNhap());
              pst.setInt(8, sp.getKhoiLuong());
              pst.setString(9, sp.getDonViTinh());
              pst.setInt(10, sp.getTonKho());
              pst.setInt(11, sp.getIDLoaiSanPham());
              pst.setInt(12, sp.getIDHangSanPham());
              pst.setString(13, sp.getThuocTinhKhachHang());
             
              pst.setInt(14, sp.getIDSize());
              pst.setInt(15, sp.getIDMauSanPham());
              pst.setInt(16, sp.getIDKe());
               pst.setInt(17, sp.getIDSanPham());
           
            pst.executeUpdate();
            System.out.println(pst);
        } catch (SQLException ex) {
             System.out.println(pst);
            System.out.println("Lỗi lấy dữ liệu");
        }  
         }else{
              try {  
           pst = DBConection.conn.prepareStatement ("UPDATE sanpham SET tensanpham = ?,ngaytao = ?,masanpham = ?,motasanpham = ?,giabanle = ?,giabanbuon = ?,gianhap = ?,khoiluong = ?,donvitinh = ?,tonkho = ?,idloaisanpham = ?,idhangsanpham = ?,thuoctinhkhachhang = ?,anhsanpham = ?,idsizesanpham = ?,idmausanpham = ?,idke = ?"+ " WHERE idsanpham = ?");
           
              pst.setString(1, sp.getTenSanPham());
              pst.setString(2, sp.getNgayTao());
              pst.setString(3, sp.getMaSanPham());
              pst.setString(4, sp.getMoTaSanPham());
              pst.setDouble(5, sp.getGiaBanLe());
              pst.setDouble(6, sp.getGiaBanBuon());
              pst.setDouble(7, sp.getGiaNhap());
              pst.setInt(8, sp.getKhoiLuong());
              pst.setString(9, sp.getDonViTinh());
              pst.setInt(10, sp.getTonKho());
              pst.setInt(11, sp.getIDLoaiSanPham());
              pst.setInt(12, sp.getIDHangSanPham());
              pst.setString(13, sp.getThuocTinhKhachHang());
             InputStream img = new FileInputStream(new File(ImagePast));
              pst.setBlob(14, img);
              pst.setInt(15, sp.getIDSize());
              pst.setInt(16, sp.getIDMauSanPham());
              pst.setInt(17, sp.getIDKe());
               pst.setInt(18, sp.getIDSanPham());
           
            pst.executeUpdate();
            System.out.println(pst);
        } catch (SQLException ex) {
             System.out.println(pst);
            System.out.println("Lỗi lấy dữ liệu");
        }  catch(FileNotFoundException e){
            System.out.println("Fail");
        }
         }
        return;
       
  
    }
  public static  String ImagePast=null;
    public static ImageIcon ResizeImage(String imagePath,byte[] pic){
        ImageIcon myImage = null;
        if(imagePath != null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;   
    }
    
//
//public static void clickrun2(){
//       // TODO add your handling code here:
//        JFileChooser file = new JFileChooser();
//        file.setCurrentDirectory(new File(System.getProperty("user.home")));
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png");
//        file.addChoosableFileFilter(filter);
//        int result = file.showSaveDialog(null);
//        if(result == JFileChooser.APPROVE_OPTION){
//            File selectedFile  = file.getSelectedFile();
//            String path = selectedFile.getAbsolutePath();
////            lblAnhSanPham.setIcon(ResizeImage(path, null));
//            ImagePast = path;
//            try {
//                pst = DBConection.conn.prepareStatement ("UPDATE sanpham SET anhsanpham = ?"+ " WHERE idsanpham = ?");
//            InputStream img = new FileInputStream(new File(ImagePast));
//              pst.setBlob(1, img);
//               pst.executeUpdate();
//            System.out.println(pst);
//            } catch (Exception e) {
//            }
//        }else{
//          
//        }
//}
}
