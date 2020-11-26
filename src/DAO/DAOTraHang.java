/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOTraHang {
    public static ResultSet LaySoHoaDon(int MaHD){
        String query = "Select * from hoadon where idhoadon = '"+MaHD+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayTraHang(){
        String query = "Select * from trahang";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayTraHangTheoID(int MaTH){
        String query = "Select * from trahang where idtrahang = '"+MaTH+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayHoaDonTheoTraHang(){
        String query ="Select * from hoadon where trahang = 0";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayChiTietHoaDonTheoHoaDon(int MaHoaDon){
        String query ="Select * from chitiethoadon where idhoadon = '"+MaHoaDon+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayChiTietHoaDonTheoMa(int MaCTHD){
        String query ="Select * from chitiethoadon where idchitiethoadon = '"+MaCTHD+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayTenSanPham(int MaSP){
        String query ="Select * from sanpham where idsanpham = '"+MaSP+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayCTHDTheoMa(int MaCTHD){
          String query = "Select * from chitiethoadon where idchitiethoadon = '"+MaCTHD+"'";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
       public static ResultSet LayCTHDTheoMaHD(int MaHD){
          String query = "Select * from chitiethoadon where idhoadon = '"+MaHD+"'";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
       public static ResultSet LayKhachHangTheoTen(int MaKH){
          String query = "Select * from khachhang where idkhachhang = '"+MaKH+"'";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
          
      }
        public static int ThemPhieuTra(DTO.DTOTraHang th) {
        String query = "INSERT INTO `trahang`(`idhoadon`, `idkhachhang`, `idnguoidung`, `sotrahang`, `trangthai`, `hoantien`, `tongtien`, `ngaynhan`, `lydotra`, `hinhthucthanhtoan`)"
                + " VALUES "
                + "('"+th.getMaHoaDon()+"',"
                + "'"+th.getMaKhachHang()+"',"
                + "'"+th.getMaNhanVien()+"',"
                + "'"+th.getSoPhieuTra()+"',"
                + "'"+th.getTrangThai()+"',"
                + "'"+th.getHoanTien()+"',"
                 + "'"+th.getTongTien()+"',"
                + "'"+th.getNgayNhan()+"',"
                + "'"+th.getLyDoTra()+"',"
                + "'"+th.getHinhThucThanhToan()+"')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
          public static int ThemCTTH(DTO.DTOChiTietTraHang ctth) {
        String query = "INSERT INTO `chitiettrahang`(`idtrahang`, `idchitiethoadon`, `idsanpham`, `soluong`, `giahang`, `phitra`, `thanhtien`, `ghichu`) "
                + "VALUES "
                + "('"+ctth.getMaTraHang()+"',"
                + "'"+ctth.getMaCTHD()+"',"
                + "'"+ctth.getMaSanPham()+"',"
                + "'"+ctth.getSoLuong()+"',"
                + "'"+ctth.getGiaHang()+"',"
                + "'"+ctth.getPhitra()+"',"
                + "'"+ctth.getThanhTien()+"',"
                + "'"+ctth.getGhiChu()+"')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
        public static int SuaPhieuTra(DTO.DTOTraHang th) {
        String query = "UPDATE `trahang` SET `trangthai`='"+th.getTrangThai()+"',`ngaynhan`='"+th.getNgayNhan()+"' WHERE `sotrahang`='"+th.getSoPhieuTra()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
        public static int SuaTonKhoKho(DTO.DTOKho kh) {
        String query = "UPDATE `kho` SET `tonkho`='"+kh.getHangDangVe()+"' WHERE `idsanpham`='"+kh.getIDSanPham()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
        public static int SuaTonKhoSP(DTO.DTOSanPham sp) {
        String query = "UPDATE `sanpham` SET `tonkho`='"+sp.getTonKho()+"' WHERE `idsanpham`='"+sp.getIDSanPham()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
         public static int SuaTongTienHD(DTO.DTOHoaDon hd) {
        String query = "UPDATE `hoadon` SET `tongtien`='"+hd.getTongTien()+"' WHERE `sohoadon`='"+hd.getSoHoaDon()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
        public static ResultSet GetByTenSP(String TenSP) {
        String cauTruyVan = "select * from sanpham where tensanpham = '" + TenSP + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
           public static int XoaCTHD(int MaSP) {
        String query = "DELETE FROM `chitiethoadon` WHERE `idsanpham`='"+MaSP+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
            public static int SuaThanhToanTraHang(DTO.DTOTraHang th) {
        String query = "UPDATE `trahang` SET `trangthai`='"+th.getTrangThai()+"',`hoantien`='"+th.getHoanTien()+"',`hinhthucthanhtoan`='"+th.getHinhThucThanhToan()+"' WHERE `sotrahang`='"+th.getSoPhieuTra()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
            public static ResultSet GetByTenPT(String SoPhieuTra) {
        String cauTruyVan = "select * from trahang where sotrahang = '" + SoPhieuTra + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
   
}
