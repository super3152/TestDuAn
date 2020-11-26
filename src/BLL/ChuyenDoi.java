/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.ThongBaoCanhBao;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class ChuyenDoi {
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    //Hàm chuyển String -> Date
    public static Date GetDate(String ngay){
        try {
           return df.parse(ngay); 
        } catch (ParseException e) {
            
        }
        return null;
    }
    
    //Hàm chuyển Date --> String
    public static String GetNgay(Date date){
        return df.format(date);
    }
    public static String DinhDangTien(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    public static double ChuyenSangSo(String tien){
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
            
            return 0;
        }
    }
    public static String doubleToString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    public static double ChuyenTien(String tien){
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
            ThongBaoCanhBao.ThongBao("Sai định dạng tiền","Thông báo");
        }
        return 0 ;
    }
     public static int ChuyenSo(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).intValue();
        } catch (ParseException ex) {
            ThongBaoCanhBao.ThongBao("Sai định dạng số","Thông báo");
        }
        return 0 ;
    }
     public static String DinhDangSo(int so){
        return NumberFormat.getNumberInstance().format(so);
    }
    public static String DinhDangNgay(Date date) {
        return df.format(date);
    }
}

